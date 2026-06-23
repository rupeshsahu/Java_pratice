const { defineConfig } = require('@playwright/test');

module.exports = defineConfig({
  testDir: 'tests',
  timeout: 30_000,
  use: {
	baseURL: process.env.BASE_URL || 'http://localhost:4000',
	extraHTTPHeaders: {
	  'Accept': 'application/json',
	  'Content-Type': 'application/json'
	}
  }
});


