# Portfolio Web Application

## Overview
This is a Spring Boot portfolio web application designed to showcase projects, skills, and personal information. The application has been configured to be deployed as a WAR file to an external Tomcat server.

## Prerequisites
- Java 17 or higher
- Apache Tomcat 11
- Maven (or use the included Maven wrapper)

## Project Structure
- `src/main/java/com/portfolio`: Java source files
  - `controller`: MVC controllers
  - `model`: Entity classes
  - `repository`: Data repositories
  - `service`: Business logic
  - `config`: Configuration classes
- `src/main/resources`: Application resources
  - `static`: Static resources (CSS, JS, images)
  - `templates`: Thymeleaf templates
  - `application.properties`: Application configuration

## Building the Application

### Setting up JAVA_HOME
Before building the application, make sure JAVA_HOME is set correctly:

1. Install Java 17 or higher if not already installed
2. Set JAVA_HOME environment variable:
   - Windows: `set JAVA_HOME=C:\path\to\your\java\installation`
   - Linux/Mac: `export JAVA_HOME=/path/to/your/java/installation`

### Building the WAR file
Once Java is installed and JAVA_HOME is set, you can build the application:

```
# Using Maven wrapper (included in the project)
./mvnw clean package

# Or if Maven is installed globally
mvn clean package
```

This will create a WAR file in the `target` directory named `portfolio-0.0.1-SNAPSHOT.war`.

## Deploying to Tomcat

1. Copy the WAR file from the `target` directory to Tomcat's `webapps` directory
2. Start Tomcat if it's not already running
3. Access the application at `http://localhost:8080/portfolio`

### Tomcat Configuration
If you need to change the port or other Tomcat settings, edit the `server.xml` file in Tomcat's `conf` directory.

## Application Configuration

### Database
The application uses an H2 in-memory database by default. To use a different database:

1. Add the appropriate database driver to the `pom.xml`
2. Update the database configuration in `application.properties`

### Context Path
The application is configured to use `/portfolio` as the context path. You can change this in `application.properties`:

```
server.servlet.context-path=/your-context-path
```

## Features
- Home page with featured projects
- Projects page with filtering capabilities
- About page with skills and experience
- Contact page with form
- Project management (add, edit, delete projects)

## Development

To run the application in development mode with the embedded server (requires changing the packaging back to `jar` in `pom.xml`):

```
./mvnw spring-boot:run
```

The application will be available at `http://localhost:8080/portfolio`.