# Code challenge
This project was created as a challenge for a software company.
It is possible to separate the street names and numbers of a provided address.

**Input:** string of address

**Output:** string of street and string of street-number as JSON object
# Application setup (Locally)

## Requirements
Before running the application, ensure the following dependencies are installed:

```
Java 11
Maven 3.2.2
Git
```

## Installation
Download the project:
```
git clone https://github.com/crusuer/CodeChallenge.git
```
Go to the project directory:
```
cd [project_dir]
```
Compile and download dependencies:
```
mvn clean package
```
Run application:
```
mvn spring-boot:run -Dspring-boot.run.arguments="address provided 123"
```