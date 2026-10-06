# Architecture
REST API -> validation service -> Liberty validator + LEF validator -> PostgreSQL release record -> characterization job seam (production: AWS Batch) -> artifact seam (production: S3).
