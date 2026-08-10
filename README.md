# Fibonacci

Simple full-stack Fibonacci example: a Spring Boot backend that exposes `/fib?n=<n>` and a React frontend that fetches that endpoint.

Prerequisites (Windows):
- Docker Desktop (includes Docker Engine and Compose)
- OR for local development: Java 17+, Maven (or use the included `mvnw` / `mvnw.cmd`), Node.js 20+ and `npm`

Run with Docker Compose (recommended):
1. From the repo root run:

```powershell
docker compose up --build
```

2. Open the apps in your browser:
- Frontend (served by Nginx in Compose): http://localhost:3000
- Backend Fibonacci endpoint: http://localhost:8080/fib?n=10

Run locally without Docker:
- Backend (PowerShell):

```powershell
cd app
.\mvnw.cmd spring-boot:run
```

- Frontend (PowerShell):

```powershell
cd my-react-app
npm install
npm run dev
```

Note: when running the frontend with `npm run dev` the Vite dev server runs on a different port and the browser may request `http://localhost:8080` directly — if so, make sure the backend is running and accepts cross-origin requests or run the frontend via Docker where Nginx proxies `/fib` -> backend.

Useful endpoints:
- Example app greeting: http://localhost:8080/app?name=YourName
- Fibonacci example: http://localhost:8080/fib?n=10

Troubleshooting:
- If the frontend can't reach the backend when both are in Docker Compose, ensure both services are `up` and check logs: `docker compose logs backend` and `docker compose logs frontend`.
- If containers run on different machines, update the frontend proxy or call the backend's reachable IP/hostname and open the backend port in any firewalls.

If you want, I can add a small health-check, enable CORS in the Spring app, or add a Vite proxy configuration — tell me which you'd prefer.