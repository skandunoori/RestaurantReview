# RestaurantReview

# Introduction
Restaurant Review Repo is a Backend Application Built using technologies like Spring Boot, Hibernate, MySQL, JWT. This application allows users to create a profile, Restaurants to create a restaurant, food and menu entities. The users and the restaurants are also allowed to provide contact information such as email address and mobile number. In addition, the Application provides APIs allowing users to comment and rate restaurants. This application provides Authentication using JWT. Thereby to create a restaurant, provide ratings and comments, a user must be authenticated and must include bearer token in header.

# How to Run the Application
To run the Application follow the following Steps,
1. Clone the Repository and change the current directory path to the cloned repository path.
2. Make sure a DB instance is running with username password mentioned in the Application.properties.(Any changes in Application.properties require re building the Application)
3. Move into the target directory and run the following command "java -jar RestaurentReview-0.0.1-SNAPSHOT.jar".
4. This should bootup the application and the application starts running on port 8080.

# API Documentation
User Entity
Creating User does not need authentication. So no JWT has to be included for creating a user.
| Http Method | Path | Description | Example | Bearer Token |
|:-----------:|:----:|-------------|---------|:------------:|
|POST|/api/v1/user|Adds user to DB.|{<br/> &nbsp;"first_name": "Sanjana",<br/>&nbsp; "last_name": "Kandunoori",<br/>&nbsp;"gender": "Female",<br/>&nbsp;"birth_date": "07-30-1997",<br/>&nbsp;"username": "sanju",<br/>&nbsp;"password": "sanju1234",<br/>&nbsp;"contact": {<br/>&nbsp;&nbsp;"mobileNumber":"5104930930",<br/>&nbsp;&nbsp;"email":"sanju@gmail.com"<br/>&nbsp;&nbsp;},<br/>&nbsp;"address": {<br/>&nbsp;&nbsp;"street": "19 Dal St",<br/>&nbsp;&nbsp;"apt": "C",<br/>&nbsp;&nbsp;"city": "Boston",<br/>&nbsp;&nbsp;"state": "Mass",<br/>&nbsp;&nbsp;"country": "US",<br/>&nbsp;&nbsp;"zipCode": "02130"<br/>&nbsp;}<br/>}|No|
|GET|/api/v1/user|Fetches all the users from the database.|<div align="center">No Body Required</div>|No|
|GET|/api/v1/user/{id}/|Fetches user with a specific id.|<div align="center">No Body Required</div>|No|


