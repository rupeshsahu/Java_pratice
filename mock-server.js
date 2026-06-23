// Minimal in-memory HTTP server implementing the Orders API contract
// No external dependencies - uses Node's built-in http module

const http = require('http');
const { URL } = require('url');

const PORT = process.env.PORT || 4000;

let nextId = 1;
const orders = new Map();
const STATUS_FLOW = ['pending', 'processing', 'fulfilled', 'cancelled'];

function parseJSON(req) {
  return new Promise((resolve, reject) => {
    let body = '';
    req.on('data', (chunk) => (body += chunk));
    req.on('end', () => {
      if (!body) return resolve(null);
      try {
        resolve(JSON.parse(body));
      } catch (e) {
        reject(e);
      }
    });
    req.on('error', reject);
  });
}

function sendJSON(res, statusCode, obj) {
  const payload = JSON.stringify(obj);
  res.writeHead(statusCode, { 'Content-Type': 'application/json' });
  res.end(payload);
}

function computeTotal(items) {
  if (!Array.isArray(items)) return 0;
  return items.reduce((s, it) => s + (it.price || 0) * (it.qty || 1), 0);
}

const server = http.createServer(async (req, res) => {
  const url = new URL(req.url, `http://localhost:${PORT}`);
  const path = url.pathname;
  try {
    if (req.method === 'POST' && path === '/orders') {
      const body = await parseJSON(req);
      const id = String(nextId++);
      const items = body && body.items ? body.items : [];
      const total = body && body.total !== undefined ? body.total : computeTotal(items);
      const status = (body && body.status) || 'pending';
      const createdAt = new Date().toISOString();
      const order = { orderId: id, id, status, total, createdAt, items };
      orders.set(id, order);
      sendJSON(res, 201, order);
      return;
    }

    if (req.method === 'GET' && path.startsWith('/orders/')) {
      const id = path.split('/')[2];
      if (!orders.has(id)) {
        res.writeHead(404); res.end(); return;
      }
      sendJSON(res, 200, orders.get(id));
      return;
    }

    if (req.method === 'PUT' && path.startsWith('/orders/')) {
      const id = path.split('/')[2];
      if (!orders.has(id)) { res.writeHead(404); res.end(); return; }
      const body = await parseJSON(req);
      const order = orders.get(id);
      // Only allow status updates or total updates
      if (body && body.status !== undefined) {
        const from = STATUS_FLOW.indexOf(order.status);
        const to = STATUS_FLOW.indexOf(body.status);
        if (to === -1) {
          sendJSON(res, 400, { error: 'invalid status' }); return;
        }
        if (to < from) {
          sendJSON(res, 409, { error: 'status cannot move backward' }); return;
        }
        order.status = body.status;
      }
      if (body && body.total !== undefined) {
        order.total = body.total;
      }
      orders.set(id, order);
      sendJSON(res, 200, order);
      return;
    }

    if (req.method === 'DELETE' && path.startsWith('/orders/')) {
      const id = path.split('/')[2];
      if (!orders.has(id)) { res.writeHead(404); res.end(); return; }
      orders.delete(id);
      res.writeHead(204); res.end(); return;
    }

    // fallback
    res.writeHead(404); res.end();
  } catch (err) {
    console.error('server error', err);
    sendJSON(res, 500, { error: String(err) });
  }
});

server.listen(PORT, () => {
  console.log(`Mock orders API listening on http://localhost:${PORT}`);
});

