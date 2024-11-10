

```markdown
# Journal Entry Backend

This is a backend service for a journal entry application built with Spring Boot. It allows users to securely create, view, and manage their own journal entries. The application uses Spring Security with JWT for user authentication, ensuring that each user can access only their own journal entries.

## Features

- **User Authentication and Authorization**: Secure access to user-specific data with Spring Security.
- **User-specific Journal Entries**: Users can create, update, view, and delete only their own entries.
- **MongoDB Atlas for Database**: Uses MongoDB for flexible, scalable data storage.
- **RESTful APIs**: Adheres to REST principles for consistent endpoint design.

## Tech Stack

- **Java 11**
- **Spring Boot**
- **Spring Security**
- **MongoDB Atlas**
- **Maven**

## Getting Started

### Prerequisites

- **Java**: JDK 11 or later
- **MongoDB Atlas**: Create an account and set up a cluster [here](https://www.mongodb.com/atlas/database).
- **Maven**

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Harsh112233445566/Springboot_Journal_application_backend.git
   ```

2. **Configure MongoDB Atlas**:
   - Update the `application.properties` file with your MongoDB Atlas URI.
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/<dbname>?retryWrites=true&w=majority
   ```

3. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

### API Endpoints
 Just check the controllers code for end points and you can change them according to your preference




