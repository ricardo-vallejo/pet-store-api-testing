# Pet-store Api Testing
Project to study api testing using Maven, Java and Rest Assured

---
## Dependencies Installed
- [Rest Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured)
- [JUnit 5 Api](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api)
- [JUnit 5 Engine](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine)
- [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
- [Log4j](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core) - [Log4j Api](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api)
- [Java Faker](https://mvnrepository.com/artifact/com.github.javafaker/javafaker)
- [Allure Rest Assured](https://mvnrepository.com/artifact/io.qameta.allure/allure-rest-assured)
- [Allure JUnit 5](https://mvnrepository.com/artifact/io.qameta.allure/allure-junit5)

### Rest Assured
Java DSL for easy testing of REST services.
### JUnit 5 Api and Engine
Unit testing framework for Java. The API allows to write the test cases and the engine allows to execute them. 
### Jackson Databind
General data-binding functionality for JSON.
### Log4j
Apache log implementation.
### Java Faker
This library is a port of Ruby's faker gem (as well as Perl's Data::Faker library) that generates fake data. It's useful when you're developing a new project and need some pretty data for showcase.
### Allure Rest Assured
Module allure-rest-assured of Allure Framework.
### Allure JUnit 5
Module allure-junit5 of Allure Framework.

---
## How to run the project

1. To run the test you must execute the command `mvn clean test`
2. To generate the report you must execute the command `mvn allure:report`
3. To visualize the report you must execute the command `mvn allure:server`