#  AllinTravel Web App

Welcome to the AllinTravel Web App project! This is a simple Spring Boot web application designed to help users find their next ideal travel destination. The app features a login ans Registration Page, a homepage with a welcome message and a button that leads to a series of questions about travel preferences and finally a Summary Page with your answers of the questions and the ideal destination.

## Prerequisites

Before you can run this project, make sure you have the following installed on your laptop:

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 11 or later)
- [Maven](https://maven.apache.org/download.cgi)
- An IDE (like [Eclipse](https://www.eclipse.org/downloads/), [IntelliJ IDEA](https://www.jetbrains.com/idea/download/), or [Spring Tool Suite](https://spring.io/tools))
- Mysql (https://dev.mysql.com/downloads/installer/)

## Installation
1. **Make a Mysql Database**
   In mysql make a localhost connection with username :root and password : Cm@29012004@p
   Then, create a database called registration and there run the following:
      CREATE TABLE travel_questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(255),
    question TEXT,
    is_multiple_choice TINYINT(1)
);

INSERT INTO travel_questions (category, question, is_multiple_choice) VALUES
('Personal Interests and Preferences', 'What are your interests? (e.g., history, nature, art, food, adventure)', 0),
('Personal Interests and Preferences', 'Do you prefer urban or rural settings?', 1),
('Personal Interests and Preferences', 'Are you looking for relaxation or an active trip?', 1),
('Personal Interests and Preferences', 'Do you have any specific hobbies or activities you want to pursue during your travel (like hiking, diving, skiing, or cultural experiences)?', 0),
('Budget and Duration', 'What is your budget for the trip?', 0),
('Budget and Duration', 'How long do you plan to travel?', 0),
('Budget and Duration', 'Are you looking for luxury experiences, budget travel, or something in between?', 1),
('Travel Experience and Comfort Zone', 'Are you an experienced traveler or is this one of your first major trips?', 1),
('Travel Experience and Comfort Zone', 'Do you prefer well-trodden destinations or off-the-beaten-path adventures?', 1),
('Travel Experience and Comfort Zone', 'How comfortable are you with language barriers or cultural differences?', 0),
('Season and Weather Preferences', 'What time of year are you planning to travel?', 0),
('Season and Weather Preferences', 'Do you have a preference for warm, cold, or temperate climates?', 1),
('Season and Weather Preferences', 'Are you looking to avoid certain weather conditions, like monsoon season or extreme cold?', 0),
('Health and Safety Considerations', 'Do you have any health concerns or dietary restrictions that might affect your destination choice?', 0),
('Health and Safety Considerations', 'Are you looking for destinations with robust healthcare facilities?', 0),
('Health and Safety Considerations', 'What is your comfort level with the current health and safety situation (like political stability, crime rate, pandemic conditions) in potential destinations?', 0),
('Travel Companions', 'Are you traveling alone, with a partner, or in a group?', 1),
('Travel Companions', 'If traveling with others, what are their interests and preferences?', 0),
('Travel Companions', 'Are there any specific needs for your travel companions, like family-friendly activities or accessibility considerations?', 1),
('Purpose of the Trip', 'Is the trip for relaxation, adventure, cultural exploration, or something else?', 1),
('Purpose of the Trip', 'Are there specific landmarks, events, or experiences you want to include in your trip?', 0);

CREATE TABLE question_choices (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT,
    choice VARCHAR(255)
);

INSERT INTO question_choices (id, question_id, choice) VALUES
(1, 2, 'Urban'),
(2, 2, 'Rural'),
(3, 3, 'Relaxation'),
(4, 3, 'Active'),
(5, 7, 'Luxury Experiences'),
(6, 7, 'Budget Travel'),
(7, 7, 'In Between'),
(8, 8, 'Experienced Traveler'),
(9, 8, 'First Major Trips'),
(10, 9, 'Well-Trodden Destinations'),
(11, 9, 'Off-the-Beaten-Path Adventures'),
(12, 12, 'Warm Climates'),
(13, 12, 'Cold Climates'),
(14, 12, 'Temperate Climates'),
(15, 17, 'Alone'),
(16, 17, 'With a Partner'),
(17, 17, 'In a Group'),
(18, 19, 'Family-Friendly Activities'),
(19, 19, 'Accessibility Considerations'),
(20, 20, 'Relaxation'),
(21, 20, 'Adventure'),
(22, 20, 'Cultural Exploration'),
(23, 20, 'Something Else');

2. **Download the project from github**

   
     Download the last commit from the main branch and extract the .zip file 



3. **Open your terminal**



4. **Build the Project**

Navigate to the project root directory in your terminal(usually ends with ALLinTravel-main\) and run:




`set openai.apikey=YOUR API KEY`


`mvn clean install`


This command builds the project and downloads the necessary dependencies and set a value to path variable openai.apikey .

## Running the Application

1. **Compile Application**

In the project root directory, run:

`mvn compile`


This command compiles the Spring Boot application.


2.**Create the -jar File**



 In the project root Directory, run:
 
 `mvn package`


 This command creates the -jar file to run the application

 3.**Run the Application**

 
 Change directory to target\ (`cd target\`)
 Then run :
 
 `java -jar helloworld-0.0.1-SNAPSHOT.jar`
 This command starts the application

4. **Access the Application**

Open your web browser and go to `http://localhost:8080`.

You should see the login page  of the web application.

## Project Structure

Here is an overview of the project structure:

- `src/main/java`: Contains the Java source files.
- `src/main/resources`: Contains the application resources, such as HTML templates and static assets.
- `src/main/resources/templates`: Contains the Thymeleaf templates for the web pages.
- `src/main/resources/static`: Contains static resources like images and CSS files.
- `pom.xml`: The Maven configuration file.
- 'target/' : Contains the .jar file which runs the project(see above) and the compiled .class files
  The AI model we used is `gpt-3.5-turbo-instruct`
## Pages and Features
-**Login and Registration Page**:Drives you to Home Page when you login
- **Home Page**: Displays a welcome message and a "Let's Start" button.
- **Questionnaire Page**: Interactive questions about travel preferences. (Accessible by clicking the "Let's Start" button on the Home Page)
- **Summary page**-: Displays a message with your answers of the questions and up to 3 ideal travel destinations 
## UML Diagramm
![final_project mdj_StarUML_](https://github.com/douranos/ALLinTravel/assets/146987465/8b992ce4-1d3f-4db6-9ef2-af92bcee2fc9)


