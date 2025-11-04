# Code Signing Certificate Manager

A full-stack application for managing code signing certificates and tracking signed files. Built with Spring Boot backend and Angular frontend.

## Architecture

- **Backend**: Spring Boot 3.2.0 with MongoDB
- **Frontend**: Angular 20 with Angular Material
- **Database**: MongoDB

## Features

- Certificate management (create, list, view)
- Signed file tracking and management
- RESTful API with CORS support
- Modern Angular UI with Material Design

## Screenshots

![Application Overview](image.png)

![Certificate Management](image%20copy.png)

![Signed Files](image%20copy%202.png)

![Dashboard](image%20copy%203.png)

## Prerequisites

- Java 17+
- Node.js 18+
- MongoDB
- Maven 3.6+

## Quick Start

### Backend Setup

```bash
cd backend_bundle
mvn clean install
mvn spring-boot:run
```

Backend runs on `http://localhost:8080`

### Frontend Setup

```bash
cd code-signing-cert-manager-frontend
npm install
npm start
```

Frontend runs on `http://localhost:4200`

### Database Setup

Ensure MongoDB is running on `mongodb://localhost:27017/certificatedb`

## API Endpoints

### Certificates
- `POST /api/certificates` - Issue new certificate
- `GET /api/certificates` - List all certificates

### Signed Files
- `POST /api/signed-files` - Add signed file record
- `GET /api/signed-files` - List all signed files

## Project Structure

```
├── backend_bundle/          # Spring Boot backend
│   ├── src/main/java/       # Java source code
│   └── src/main/resources/  # Configuration files
└── code-signing-cert-manager-frontend/  # Angular frontend
    └── src/app/             # Angular components and services
```

## Development

### Backend
- Uses Spring Boot with MongoDB integration
- Includes validation, CORS configuration
- Follows layered architecture (Controller → Service → Repository)

### Frontend
- Angular 20 with standalone components
- Angular Material for UI components
- Reactive forms and HTTP client integration

## Configuration

Backend configuration in `application.properties`:
- MongoDB URI: `mongodb://localhost:27017/certificatedb`
- Server port: `8080`
- CORS enabled for frontend origins

## License

This project is for educational/demonstration purposes.