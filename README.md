#  AllinTravel Web App

Welcome to the AllinTravel Web App project! This is a simple Spring Boot web application designed to help users find their next ideal travel destination. The app features a homepage with a welcome message and a button that leads to a series of questions about travel preferences.

## Prerequisites

Before you can run this project, make sure you have the following installed on your laptop:

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 11 or later)
- [Maven](https://maven.apache.org/download.cgi)
- An IDE (like [Eclipse](https://www.eclipse.org/downloads/), [IntelliJ IDEA](https://www.jetbrains.com/idea/download/), or [Spring Tool Suite](https://spring.io/tools))

## Installation

1. **Clone the Repository**

   Open your terminal and run the following command to clone the project repository:

`git clone [URL of the project repository]`

2. **Open the Project**

Open the project in your preferred IDE.

3. **Build the Project**

Navigate to the project root directory in your terminal and run:

`mvn clean install`


This command builds the project and downloads the necessary dependencies.

## Running the Application

1. **Start the Application**

In the project root directory, run:

`mvn spring-boot:run`


This command starts the Spring Boot application.

2. **Access the Application**

Open your web browser and go to `http://localhost:8080`.

You should see the homepage of the web application.

## Project Structure

Here is an overview of the project structure:

- `src/main/java`: Contains the Java source files.
- `src/main/resources`: Contains the application resources, such as HTML templates and static assets.
- `src/main/resources/templates`: Contains the Thymeleaf templates for the web pages.
- `src/main/resources/static`: Contains static resources like images and CSS files.
- `pom.xml`: The Maven configuration file.

## Pages and Features

- **Home Page**: Displays a welcome message and a "Let's Start" button.
- **Questionnaire Page**: Interactive questions about travel preferences. (Accessible by clicking the "Let's Start" button on the Home Page)
- **About Us Page**: Provides information about the creators or purpose of the application. (Accessible via the header)


