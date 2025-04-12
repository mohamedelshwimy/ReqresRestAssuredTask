# API Automation Framework using RestAssured

This project demonstrates a structured API automation framework using **RestAssured**, **TestNG**, and **Maven**, with test cases built on the public API service: [https://reqres.in](https://reqres.in).

## 📁 Project Structure

```
api-automation-framework/
├── main/
│   ├── java/
│   │    ├── apiConfig/        
│   │    └── utils/             
│   │
│   └── resources/
│       └── testData/          
├── src/
│   └── test/
│       ├── apiVerification/    
│       ├── Base/               
│       ├── Responses/          
│       └── testCases/          
│
├── testng.xml                 
├── pom.xml                    
└── README.md                  
```

## ✅ Features

- API testing with **RestAssured**
- CRUD operations for ReqRes Apis
- Test execution and reporting with **TestNG**
- Structured and modular code
- Maven-based dependency and build management
- Assertion handler for clean and readable tests

## 🔧 Prerequisites

Ensure the following are installed:

- Java 11 or higher
- Maven 3.6+
- Git (optional, for version control)
- IDE like IntelliJ IDEA or Eclipse (recommended)

## 🚀 Setup & Run Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/mohamedelshwimy/ReqresRestAssuredTask.git
```

### 2. Configure the Environment

Edit the `src/test/resources/config.properties` file:

```properties
baseUrl = https://reqres.in
```

### 3. Build the Project

Use Maven to download dependencies and compile:

```bash
mvn clean install
```

### 4. Run Tests

Use TestNG to run the suite:

```bash
mvn test
```

Or directly from your IDE using `testng.xml`.

## 🧪 Implemented Test Scenarios

### 1. **Create a User**

- Endpoint: `POST /api/users`
- Validates user creation and response structure.

### 2. **Retrieve a User**

- Endpoint: `GET /api/users/{id}`
- Validates retrieved data matches the created user.

### 3. **Update a User**

- Endpoint: `PUT /api/users/{id}`
- Validates updates are reflected in the response.

## ⚠️ Error Handling

- Logs detailed error messages for debugging
- Test failures include descriptive assertions

## 📌 Dependencies

- [RestAssured](https://rest-assured.io/)
- [TestNG](https://testng.org/)
- [Maven](https://maven.apache.org/)

All dependencies are listed in the `pom.xml`.

## 👨‍💻 Code Quality

- Modular design and clean code principles followed
- Utilities and configurations are reusable across test cases

## 📂 Version Control

The project is tracked with **Git**. Feel free to fork or contribute.

## 📞 Support

For any issues or suggestions, feel free to raise an issue in the repository.

> Happy Testing! 🚀
