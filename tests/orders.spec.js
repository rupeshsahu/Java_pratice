const { test, expect } = require('@playwright/test');

// Simple contract tests for the Orders API as specified.
// The tests target the baseURL in playwright.config.js (default http://localhost:4000)

test.describe('Orders API contract', () => {
  const computeTotal = (items) => items.reduce((s, it) => s + (it.price || 0) * (it.qty || 1), 0);

  test('create -> get -> update status forward -> reject backward -> delete', async ({ request }) => {
    // 1) Create an order
    const createPayload = {
      items: [
        { sku: 'A1', qty: 2, price: 10.0 },
        { sku: 'B2', qty: 1, price: 5.0 }
      ],
      customer: { name: 'Jane Doe' }
    };

    const createResp = await request.post('/orders', { data: createPayload });
    expect(createResp.status()).toBe(201);
    const created = await createResp.json();
    expect(created).toBeTruthy();
    const orderId = created.orderId || created.id;
    expect(orderId).toBeTruthy();
    expect(created.status).toBeTruthy();
    expect(created.createdAt).toBeTruthy();
    if (created.total !== undefined) {
      expect(created.total).toBeCloseTo(computeTotal(createPayload.items));
    }

    // 2) GET the order
    const getResp = await request.get(`/orders/${orderId}`);
    expect(getResp.status()).toBe(200);
    const fetched = await getResp.json();
    expect(fetched.orderId || fetched.id).toBe(orderId);
    expect(fetched.status).toBe(created.status);

    // 3) Update the status forward (allowed)
    const initialStatus = fetched.status;
    const nextBy = {
      pending: 'processing',
      processing: 'fulfilled',
      fulfilled: 'cancelled'
    };
    const nextStatus = nextBy[initialStatus] || 'processing';

    const updateResp = await request.put(`/orders/${orderId}`, { data: { status: nextStatus } });
    expect(updateResp.status()).toBeGreaterThanOrEqual(200);
    expect(updateResp.status()).toBeLessThan(300);
    const updated = await updateResp.json();
    expect(updated.status).toBe(nextStatus);

    // 4) Attempt to move status backward (should be rejected)
    const backwardResp = await request.put(`/orders/${orderId}`, { data: { status: initialStatus } });
    expect(backwardResp.status()).toBeGreaterThanOrEqual(400);

    // 5) Delete the order
    const deleteResp = await request.delete(`/orders/${orderId}`);
    expect(deleteResp.status()).toBe(204);

    // GET after delete should return 404 or 410
    const getAfterDelete = await request.get(`/orders/${orderId}`);
    expect([404, 410]).toContain(getAfterDelete.status());
  });
});

