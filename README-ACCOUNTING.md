[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/iDPpP-d0)
# **Java API Assessment**

## **Introduction**
Dive into the world of API development using Java and SpringBoot. We're handing over a skeleton codebase; your challenge is to shape a top-notch API from it.

You can build any API of your choosing, but it must include the following:

1. At least one algorithm
1. Unit test at least one class
1. Store the data in a JSON file 
1. Exception handling 
1. Evidence of inheritance
1. Good use of HTTP Protocols - methods, request and response, have full CRUD operations supported 
1. Documentation

### **Learning Outcomes:**

By the end of this assessment, you should be able to:

1. **Design and Architect APIs**: Get to grips with the nitty-gritty of curating a top-quality API, focusing on data flow and endpoint interactions.
1. **Implement Best Practices**: Showcase your adherence to Java & SpringBoot coding standards, error handling, and optimal project structure.
1. **Code Integration**: Seamlessly combine your creations with the provided skeleton codebase.
1. **Exception Management**: Efficiently handle exceptions, ensuring your API remains sturdy and dependable.

Onward with this assessment, you're set for a deep dive into API development with Java and SpringBoot.

## **Design & Requirements**

### **Design Considerations:**
- **API Flow**: Map out your API's progression, from endpoints to their functionalities.

### **Requirements List:**
- **Core**: Make use of Java and SpringBoot.
- **End Points**: Ensure they are detailed and fully operational.
- **Error Handling**: Your API should handle mishaps gracefully and return informative feedback.

### **Learning Outcomes:**
- Acknowledge the pivotal role of a focused design in APIs.
- See firsthand how a detailed requirements list can pave the way for successful development.

## **Repository Management**

- **Consistent Commits**: Commit often, capturing your progress and thought process.
- **README**: Not just an afterthought. Fill it with the essence of your API, setup instructions, and other salient details.

### **Learning Outcomes:**
- Hone your skills in effective version control.
- Recognise the value of a well-curated repository.

## **Code Quality & Structure**

- **Best Practices**: Stick to Java and SpringBoot best practices and conventions.
- **Modularity**: Your code should be modular, reusable, and easily comprehensible.

#### **Learning Outcomes:**
- Craft clean, efficient, and maintainable code.
- Harness Java and SpringBoot to the fullest.

---

## Getting Started

- [Prerequisites](#prerequisites)

- [Setup](#setup)

### Prerequisites

Before you begin, make sure you have the following installed:

1. [JDK 17](https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-17) (or higher)

2. [Git](https://git-scm.com/downloads)

3. [Visual Studio Code](https://code.visualstudio.com/Download)
   1. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
   2. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

Also make sure you have accounts for the following:

1. [GitHub](https://github.com/signup)

### Setup

#### 1. Clone the Repository

```sh
git clone [REPO_URL]
cd [REPO_NAME]
```

Replace [REPO_URL] with the link to your GitHub repository and [REPO_NAME] with the repository's name.

#### 2. Install Dependencies

Open a terminal at the root of the repo directory and run the following command to install the dependencies:

```sh
./mvnw clean dependency:resolve
```

If you are on a Windows machine, that will be:
```cmd
mvnw clean dependency:resolve
```

You should see console output similar to the following:

```sh
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.cbfacademy:api-assessment >--------------------
[INFO] Building api-assessment 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ api-assessment ---
[INFO] Deleting /Users/user/Dev/cbfacademy/java-api-assessment/target
...
[truncated output]
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.060 s
[INFO] Finished at: 2023-10-03T16:18:25+01:00
[INFO] ------------------------------------------------------------------------
```

#### 3. Running the Application

To start the API in VS Code, press `F5` or tap the 'Play' icon for the `api-assessment` app in the Spring Boot Dashboard.

Alternatively, to start the API from the terminal, run the following command:
