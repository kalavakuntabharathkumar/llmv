# Liberty/LEF Model Release and Validation Platform
Java 17 + Spring Boot REST demo for validating Liberty and LEF model releases.

Run:
```bash
docker compose up --build
```
API: `GET /api/health`, `GET /api/models`, `POST /api/models/validate`, `GET /api/releases/{id}`
Tests: `mvn test`

AWS Batch/S3 are represented by integration seams; no credentials or cloud resources are bundled.
