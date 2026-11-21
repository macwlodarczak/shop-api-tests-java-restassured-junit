# 🚀 REST API Test Automation Framework

Automated API testing framework built with **Java**, **RestAssured**, and **JUnit 6**. Designed to validate RESTful services using a clean, modular architecture with dedicated API clients, reusable request/response specifications, and multi-environment configuration support.

---

## 🛠️ Tech Stack

* **Language:** Java
* **API Testing Library:** RestAssured
* **Test Runner:** JUnit 6
* **Build Tool:** Maven

---

## 📁 Project Structure

```text
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       │   └── com.github.macwlodarczak
│       │       ├── api
│       │       │   ├── clients
│       │       │   │   └── UserClient.java        # Endpoint wrappers & HTTP request methods
│       │       │   ├── models                     # POJO classes for request/response payloads
│       │       │   └── specs                      # Reusable RestAssured Request/Response specifications
│       │       ├── base
│       │       │   └── BaseTest.java              # Base test setup, hooks & configuration loading
│       │       ├── tests
│       │       │   └── users
│       │       │       └── UsersTests.java        # Automated test suites for Users endpoints
│       │       └── utils                          # Helper methods & test data generators
│       └── resources
│           ├── config-local.properties            # Local environment configuration
│           └── config-qa.properties               # QA environment configuration
├── pom.xml                                        # Project dependencies and build configuration
└── README.md
