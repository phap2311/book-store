# book-store
•	Bookstore API

Introduction
   The Bookstore API project is a RESTful service built with Spring Boot that provides basic features 
for managing book information, including creating, viewing, updating, and deleting books. 
The application uses JDK 21 and Gradle as its build tool.

Technologies Used
   Java 21
   Spring Boot 3.3.5
   Gradle 8.10.2 - For dependency management and project building
   JPA - For database interaction
   MySQL - The main SQL database for the project.

Project Structure
   controller/: Contains REST controllers to handle HTTP requests.
   dto/: Defines data transfer classes.
   exception/: Manages global and custom exceptions.
   model/: Entity classes representing database tables.
   repository/: Data access object (DAO) layer.
   service/: Service layer for business logic.
   util/: Utility classes for JSON responses.

Setup and Run
1. System Requirements
   JDK 21
   Gradle 8.10.2 (or use the included Gradle Wrapper)
   MySQL for data storage.
2. Database Configuration
   In src/main/resources/application.properties, add the following configuration for the MySQL database connection:
   
   # MySQL database configuration
   spring.datasource.url=jdbc:mysql://localhost:3306/book_store?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false
   spring.datasource.username=root
   spring.datasource.password=123456
   
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   
   # Application name
   spring.application.name=book-store
3. Build and Run the Application
   Use the following commands to build and run the application:
   # Build the project
   ./gradlew build
   
   # Run the application
   ./gradlew bootRun
   The application will start at http://localhost:8080.
   
API Endpoints
Create a New Book
   URL: /books
   Method: POST
   Request Body:
   {
   "title": "Great Expectations",
   "author": "Charles Dickens",
   "published_date": "1860-12-01",
   "isbn": "1269308353",
   "price": 10.31
   }

Get Book by ID
   URL: /books/{id}
   Method: GET
   Response: Detailed information of the book with the specified ID.

List All Books
   URL: /books
   Method: GET
   Response: List of books with pagination support using size and page parameters.

Update Book
   URL: /books/{id}
   Method: PUT
   Request Body: Update book details, structured as in book creation.
   Response: Updated information of the book.

Delete Book
   URL: /books/{id}
   Method: DELETE
   Response: Confirmation of successful deletion.

Error Handling
   The application includes a custom error-handling system that returns error codes and clear messages when exceptions
occur. Errors are managed through the GlobalHandleException class, with error codes defined in the ErrorCode enum.
Testing
   To test, you can use tools like Postman or run the default Spring Boot unit tests:
   ./gradlew test

Contributing
To contribute, please open a Pull Request on the project’s main repository with details of your changes.
