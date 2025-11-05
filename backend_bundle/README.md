# Certificate Management Backend

This is a Spring Boot application for certificate management and file signing simulation. The application provides REST APIs to manage digital certificates and signed files with MongoDB as the data store.

## Prerequisites

- Java 17
- Maven 3.6+ or use the provided Maven Wrapper
- MongoDB instance running on localhost:27017

## Steps to Run the Backend

1. **Start MongoDB**
   Make sure MongoDB is running on your system. By default, the application connects to:
   ```
   mongodb://localhost:27017/certificatedb
   ```

2. **Build the Application**
   Using Maven Wrapper (recommended):
   ```bash
   # On Windows
   mvnw.cmd clean install
   
   # On macOS/Linux
   ./mvnw clean install
   ```
   
   Or using your installed Maven:
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   Using Maven Wrapper (recommended):
   ```bash
   # On Windows
   mvnw.cmd spring-boot:run
   
   # On macOS/Linux
   ./mvnw spring-boot:run
   ```
   
   Or using your installed Maven:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Application**
   The application will start on port 8080. You can access it at:
   ```
   http://localhost:8080
   ```

## API Endpoints

The application exposes REST APIs for:
- Certificate management (creation, retrieval, etc.)
- Signed file management

Check the controller classes for detailed endpoint information.

## Working Flow

### Certificate Management Flow
1. **Create Certificate**: Users can create new digital certificates through the `/api/certificates` POST endpoint
2. **View Certificates**: All certificates can be retrieved through the `/api/certificates` GET endpoint
3. **Certificate Validation**: When creating a certificate, the system validates:
   - Certificate name uniqueness
   - Valid from/to dates (valid to must be after valid from)
   - Required fields are present

### File Signing Flow
1. **Select Certificate**: Users select an existing certificate for signing
2. **Sign File**: Files are signed through the `/api/signed-files/sign` POST endpoint
3. **View Signed Files**: All signed files can be retrieved through the `/api/signed-files` GET endpoint
4. **Certificate Validation**: The system verifies the certificate exists and is active before signing

### Data Flow
1. **Frontend** sends HTTP requests to backend endpoints
2. **Controllers** receive and validate requests
3. **Services** process business logic
4. **Repositories** handle data persistence to MongoDB
5. **MongoDB** stores certificate and signed file records
6. **Response** is sent back to frontend