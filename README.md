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
|:-----------:|:----:|:-----------:|:-------:|:------------:|
|POST|/api/v1/user|Adds user to DB. Expects the user to be present in the body.|{ "first_name": "Sanjana",<br/> "last_name": "Kandunoori",<br/>"gender": "Female",<br/>"birth_date": "07-30-1997",<br/>"username": "sanju",<br/>"password": "sanju1234",<br/>"contact": {<br/>"mobileNumber":"5104930930",<br/>"email":"sanju@gmail.com"<br/>},<br/>"address": {<br/>"street": "19 Dal St",<br/>"apt": "C",<br/>"city": "Boston",<br/>"state": "Mass",<br/>"country": "US",<br/>"zipCode": "02130"<br/>}<br/>}|No|


