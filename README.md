# User API

This project is a Spring Boot application providing a User API. It allows you to create users, retrieve users by username, and retrieve all users.

## Building from Sources

1.  **Prerequisites:**
    * Java 17 or later
    * Maven


2.  **Clone the Repository (if applicable):**

    ```
    git clone https://github.com/youhaff/userapi.git
    cd userapi
    ```

3.  **Build the Application:**

    ```
    mvn clean package
    ```


4.  **Run the Application:**

    ```
    mvn spring-boot:run
    ```

    The application will start on `http://localhost:8080`

## API Usage

The API provides the following endpoints:

* **POST /user:** Create a new user
* **GET /user/{username}:** Retrieve a user by username
* **GET /user:** Retrieve all users

### POST /user (Create User)

* **Method:** POST
* **URL:** `http://localhost:8080/user`
* **Content-Type:** `application/json`
* **Request Body (JSON):**

    ```
    {
      "username": "Robert",
      "birthDate": "1990-02-28",
      "country": "France",
      "phoneNumber": "0612345678",
      "gender": "MALE"
    }
    ```

    * `username` (required): User's username
    * `birthDate` (required): User's birthdate (yyyy-MM-dd)
    * `country` (required): User's country ("France" for adults)
    * `phoneNumber` (optional): User's phone number
    * `gender` (optional): User's gender (MALE or FEMALE)

* **Response:**
    * 201 Created: User created successfully
    * 400 Bad Request: Validation errors (e.g., invalid birthdate, non-French resident, not adult)

### GET /user/{username} (Get User by Username)

* **Method:** GET
* **URL:** `http://localhost:8080/user/{username}`
* **Response:**
    * 200 OK: User details in JSON format
    * 404 Not Found: User not found

### GET /user (Get All Users)

* **Method:** GET
* **URL:** `http://localhost:8080/user`
* **Response:**
    * 200 OK: List of all users in JSON format
