# **Accounting Workbook API Project**

## Table  of Contents

* [General Info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Project Requirements](#Requirements)


## General Info

The application is meant to record business transactions onto a ledger, with a JSON file taking the place of the ledger.

## Technologies
1. [JDK 17](https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) (or higher)
2. [Git](https://git-scm.com/downloads)
3. [Visual Studio Code](https://code.visualstudio.com/Download)
   1. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
   2. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
4. [Postman or other RESTful API testing tool](https://www.postman.com/downloads/)


## Setup

### 1. Clone the Repository

```cmd
git clone [REPO_URL]
cd [REPO_NAME]
```
Replace [REPO_URL] with the link to your GitHub repository and [REPO_NAME] with the repository's name.


### 2. Install the Dependencies

Open a terminal at the root of the repo directory and run the following command to install the dependencies:

```cmd
./mvn clean dependency:resolve
```


### 3.Running the Application

```cmd
mvnw spring-boot:run
```
Open your browser and navigate to `http://localhost:8080`.


## Project Requirements

### 1. At least one algorithm

Throughout the programme I have used algorithms to find, categorise and return data.


### 2. Unit test at least one class



### 3. Store the data in a JSON file

| Controller | Json File |
|------------|-----------|
| User       |           |
| Accounts   |           |


### 4.Evidence of inheritance

| Controller | Json File |
|------------|-----------|
| User       |           |
| Accounts   |           |




### 5.Good use of HTTP Protocols - methods, request and response, have full CRUD operations supported

| Class                                                                                                                                            | HTTP Method | EndPoint | Response & Request Formats  **Response**: JSON responses with appropriate status codes (e.g 200 OK, 500 Internal Error).  **Request** Utilising postman requires an URL representing the API endpoint. | Authentication & Authorisation<br/>Ideally each user has roles (READ ONLY and Finance User). Access to endpoints would be tailored to these roles. |
|--------------------------------------------------------------------------------------------------------------------------------------------------|-------------|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| [UserController](C:\workspace\projects\springbootproject\src\main\java\com\accountingworkbook\springbootproject\controllers\UserController.java) | Post        | Create   |                                                                                                                                                                                                        | This endpoint would be restricted to those with "FinanceUser" access.                                                                            |
| [UserController]                                                                                                                                 | Get         | Read     |                                                                                                                                                                                                        | Those with "READ ONLY" roles would have access to some of the Get end points.           |
| March                                                                                                                                            | Put         | Update   |                                                                                                                                                                                                        | This endpoint would be restricted to those with "FinanceUser" access.                   |
| March                                                                                                                                            | Delete      | Delete   |                                                                                                                                                                                                        | This endpoint would be restricted to those with "FinanceUser" access.                  |

### 6.Documentation

Provided in the form of this README markdown. 

