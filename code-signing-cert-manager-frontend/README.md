# CodeSigningCertManagerFrontend

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 20.3.8.

## Development server

To start a local development server, run:

```bash
ng serve
```

Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
ng generate --help
```

## Building

To build the project run:

```bash
ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Karma](https://karma-runner.github.io) test runner, use the following command:

```bash
ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.

## Working Flow

### Application Structure
The frontend is organized into the following key components:

1. **Certificate Management**
   - `certificate-add` component: Form for creating new certificates
   - `certificate-list` component: Displays all existing certificates

2. **File Signing**
   - `signedfile-add` component: Interface for signing files with certificates
   - `signedfile-list` component: Displays all signed files

### User Workflow

1. **Certificate Creation**
   - Navigate to "Add Certificate" page
   - Fill in certificate details (name, issuer, validity dates)
   - Submit form to create certificate via backend API

2. **Certificate Viewing**
   - Navigate to "Certificates" page
   - View list of all created certificates with their details

3. **File Signing**
   - Navigate to "Sign File" page
   - Select a certificate from the dropdown
   - Enter file name to be signed
   - Submit to create signed file record via backend API

4. **Signed File Viewing**
   - Navigate to "Signed Files" page
   - View list of all signed files with certificate information

### Data Flow
1. **Components** handle user interactions and form validation
2. **Services** communicate with backend APIs
3. **HTTP Client** sends requests to backend endpoints
4. **Backend** processes requests and returns data
5. **Components** display received data to users
