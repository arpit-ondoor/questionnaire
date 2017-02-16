# Questionnaire

This is an example of implementation of a Questionnaire.

Stack:
- Spring Boot on the backend
- AngularJS 2 on the frontend
- TypeScript as frontend language
- mysql for database

Prerequisites:
- install maven and npm
- install mysql
- install angular-cli
```bash
npm install -g @angular/cli
```
# Installation

**BEFORE YOU INSTALL:** please read the [prerequisites](#prerequisites)

####For Run(js server + java server):
1. Create Database
 * mysql -u username -p  < [PARENT_MODULE]/sql/questionnaire_db.sql
2. Package the java project or launch Application.java from your IDE
 * mvn clean package 
3. launch the backend spring boot application, it runs in localhost:8081
    * java -jar [PARENT_MODULE]/server/target/questionnaire.war
4. launch the webpack server for the frontend
    * cd [PARENT_MODULE]/webClient
    * npm install
    * ng serve
5. go on http://localhost:4200

