Orders API Playwright tests

Files added:
- package.json - devDependency on @playwright/test and scripts
- playwright.config.js - baseURL default http://localhost:4000
- tests/orders.spec.js - Playwright API tests for the orders contract
- mock-server.js - minimal in-memory server implementing the contract (no external deps)

Quick start (PowerShell):

```powershell
# from project root
npm install
# start the mock server in background (or use npm run start:mock)
Start-Process -NoNewWindow -FilePath node -ArgumentList 'mock-server.js'
# run tests
npx playwright test
```

If you prefer a single-line to run the mock server and tests (foreground):

```powershell
node mock-server.js ; npx playwright test
```

Notes:
- The mock server listens on port 4000 by default. Set BASE_URL env var or PORT env var to change.
- The tests exercise: POST /orders, GET /orders/{id}, PUT (status forward/backward), DELETE.

