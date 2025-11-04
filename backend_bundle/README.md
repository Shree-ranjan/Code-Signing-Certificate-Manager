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