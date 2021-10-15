# iqbusinessregistration
Before you run the project

Make show you have maven running in your local machine the version here is 3.8.1

Make sure you have java 8 is installed in your machine

You may use gitbash to clone the project

Make sure you have IDE running ,this was ran on intellij 2021 version

Make sure you have MYSQL intalled on your machine




How to run the project?

1. clone the project from github
2. Open the project on your Intellij or any other IDE you maybe using
3. go to application.properties to config your database
4. run mvn clean install package
5. Then run the micro service

When the application running 

You can start your postman or go to your browser and start swagger-ui

To test using swagger-ui use the url

http://localhost:8080/swagger-ui.html

You will find 2 endpoints

Post : http://localhost:8080/v1/person
{
  "fullName": "Ndumiso Mbete",
  "idNumber": 8706112348084,
  "personId": "0",
  "telephoneNumber": "0731230109"
}
And 

Get : http://localhost:8080/v1/persons



