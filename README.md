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
# User Entity
Creating User does not need authentication. So no JWT has to be included for creating a user.
| Http Method | Path | Description | Example | Bearer Token |
|:-----------:|:----:|-------------|---------|:------------:|
|POST|/api/v1/user|Adds user to DB.|{<br/> &nbsp; "first_name": "Sanjana",<br/>&nbsp; "last_name": "Kandunoori",<br/>&nbsp; "gender": "Female",<br/>&nbsp; "birth_date": "07-30-1997",<br/>&nbsp; "username": "sanju",<br/>&nbsp; "password": "sanju1234",<br/>&nbsp; "contact": {<br/>&nbsp; "mobileNumber":"5104930930",<br/>&nbsp; "email":"sanju@gmail.com"<br/>&nbsp;},<br/>&nbsp; "address": {<br/>&nbsp; "street": "19 Dal St",<br/>&nbsp; "apt": "C",<br/>&nbsp; "city": "Boston",<br/>&nbsp; "state": "Mass",<br/>&nbsp; "country": "US",<br/>&nbsp; "zipCode": "02130"<br/>&nbsp; }<br/>}|No|
|GET|/api/v1/user|Fetches all the users from the database.|<div align="center">No Body Required</div>|No|
|GET|/api/v1/user/{id}|Fetches user with a specific id.|<div align="center">No Body Required</div>|No|
|PUT|/api/v1/user/{id}|Updates the user with details provided in the body.|{<br/>&nbsp; "first_name": "Kaushik",<br/>&nbsp; "last_name": "Boora",<br/>&nbsp; "gender": "Male",<br/>&nbsp;"birth_date": "07-30-1997",<br/>&nbsp;}|No|
|DELETE|/api/v1/user/{id}|Deletes user with the id mentioned in the path variable.|<div align="center">No Body Required</div>|No|

# Restaurant Entity
Creating restaurant requires authorization. Hence, JWT must be included in the header.
| Http Method | Path | Description | Example | Bearer Token |
|:-----------:|:----:|-------------|---------|:------------:|
|POST|/api/v1/restaurant|Adds restaurant to DB.| {<br/> &nbsp; "name": "Godavari",<br/> &nbsp; "contact": {<br/> &nbsp; "mobileNumber":"7044304130",<br/> &nbsp; "email":"sanju@gmail.com"<br/> &nbsp;},<br/> &nbsp;"address": {<br/> &nbsp;"street": "19 Dal st",<br/> &nbsp;"apt": "B",<br/> &nbsp;"city": "Boston",<br/> &nbsp;"state": "Mass",<br/> &nbsp;"country": "US",<br/> &nbsp;"zipCode": "02130"<br/> &nbsp;}<br/> &nbsp;}|Yes|
|GET|/api/v1/restaurant|Fetches all the restaurants from the database.|<div align="center">No Body Required</div>|Yes|
|GET|/api/v1/restaurant/{id}|Fetches restaurant with a specific id from the database.|<div align="center">No Body Required</div>|Yes|
|PUT|/api/v1/restaurant/{id}|Updates the restaurant with details provided in the body.| {<br/> &nbsp; "name": "Aaha",<br/> &nbsp;}|Yes|
|DELETE|/api/v1/restaurant/{id}|Deletes restaurant with the id mentioned in the path variable.|<div align="center">No Body Required</div>|Yes|

# Address Entity
Creating address requires authorization. Hence, JWT must be included in the header.
| Http Method | Path | Description | Example | Bearer Token |
|:-----------:|:----:|-------------|---------|:------------:|
|POST|/api/v1/address/restaurant/{restaurantId}|Updates the Address of a Restaurant by creating a new address.|  {<br/> &nbsp;&nbsp;"street": "19 Dal st",<br/> &nbsp;&nbsp;"apt": "B",<br/> &nbsp;&nbsp;"city": "Boston",<br/> &nbsp;&nbsp;"state": "Mass",<br/> &nbsp;&nbsp;"country": "US",<br/> &nbsp;&nbsp;"zipCode": "02130"<br/> &nbsp;}|Yes|
|POST|/api/v1/address/user/{userId}|Updates the Address of a user by creating a new address.|  {<br/> &nbsp;&nbsp;"street": "9 Elmore st",<br/> &nbsp;&nbsp;"apt": "A",<br/> &nbsp;&nbsp;"city": "Boston",<br/> &nbsp;&nbsp;"state": "Mass",<br/> &nbsp;&nbsp;"country": "US",<br/> &nbsp;&nbsp;"zipCode": "02130"<br/> &nbsp;}|Yes|
|GET|/api/v1/address|Fetches all the addresses from the database.|<div align="center">No Body Required</div>|Yes|
|GET|/api/v1/address/{id}|Fetches address with a specific id from the database.|<div align="center">No Body Required</div>|Yes|
|PUT|/api/v1/address/{id}|Updates the address with the details provided in the body.|  {<br/> &nbsp;&nbsp;"street": "198 Am st",<br/> &nbsp;&nbsp;"apt": "A",<br/> &nbsp;&nbsp;"city": "Boston",<br/> &nbsp;&nbsp;"state": "Mass",<br/> &nbsp;&nbsp;"country": "US",<br/> &nbsp;&nbsp;"zipCode": "02130"<br/> &nbsp;}|Yes|
|DELETE|/api/v1/address/{id}|Deletes address with the id mentioned in the path variable.|<div align="center">No Body Required</div>|Yes|

# Contact Entity
Creating contact requires authorization. Hence, JWT must be included in the header.
| Http Method | Path | Description | Example | Bearer Token |
|:-----------:|:----:|-------------|---------|:------------:|
|POST|/api/v1/contact/restaurant/{restaurantId}|Updates the contact of a Restaurant by creating a new contact.|{<br/> &nbsp; "email": "ks@gmail.com",<br/> &nbsp; "mobileNumber": "7044304130"<br/> &nbsp;}|Yes|
|POST|/api/v1/contact/user/{userId}|Updates the contact of a user by creating a new contact.|{<br/> &nbsp; "email": "sanjana@gmail.com",<br/> &nbsp; "mobileNumber": "5104930930"<br/> &nbsp;}|Yes|
|GET|/api/v1/contact|Fetches all the contacts from the database.|<div align="center">No Body Required</div>|Yes|
|GET|/api/v1/contact/{id}|Fetches contact with a specific id from the database.|<div align="center">No Body Required</div>|Yes|
|PUT|/api/v1/contact/{id}|Updates the contact with the details provided in the body.|{<br/> &nbsp; "email": "sai@gmail.com",<br/> &nbsp; "mobileNumber": "7044354135"<br/> &nbsp;}|Yes|
|DELETE|/api/v1/contact/{id}|Deletes contact with the id mentioned in the path variable.|<div align="center">No Body Required</div>|Yes|

# Rating Entity
Creating rating requires authorization. Hence, JWT must be included in the header.
| Http Method | Path | Description | Example | Bearer Token |
|:-----------:|:----:|-------------|---------|:------------:|
|POST|/api/v1/rating/restaurant/{restaurantId}/user/{userId}|Adds a rating provided by the user with the mentioned id to a specific id of the restaurant.|{<br/> &nbsp; "value": 2<br/> &nbsp;}|Yes|
|GET|/api/v1/rating|Fetches all the ratings from the database.|<div align="center">No Body Required</div>|Yes|
|GET|/api/v1/rating/{id}|Fetches rating with a specific id from the database.|<div align="center">No Body Required</div>|Yes|
|PUT|/api/v1/rating/{id}|Updates the rating with the details provided in the body.|{<br/> &nbsp; "value": 5<br/> &nbsp;}|Yes|
|DELETE|/api/v1/rating/{id}|Deletes rating with the id mentioned in the path variable.|<div align="center">No Body Required</div>|Yes|

# Comment Entity
Creating comment requires authorization. Hence, JWT must be included in the header.
| Http Method | Path | Description | Example | Bearer Token |
|:-----------:|:----:|-------------|---------|:------------:|
|POST|/api/v1/comment/restaurant/{restaurantId}/user/{userId}|Adds a comment provided by the user with the mentioned id to a specific id of the restaurant.|{<br/> &nbsp; "comment": "Bad"<br/> &nbsp;}|Yes|
|GET|/api/v1/comment|Fetches all the comments from the database.|<div align="center">No Body Required</div>|Yes|
|GET|/api/v1/comment/{id}|Fetches comment with a specific id from the database.|<div align="center">No Body Required</div>|Yes|
|PUT|/api/v1/comment/{id}|Updates the comment with the details provided in the body.|{<br/> &nbsp; "comment": "Delicious"<br/> &nbsp;}|Yes|
|DELETE|/api/v1/comment/{id}|Deletes comment with the id mentioned in the path variable.|<div align="center">No Body Required</div>|Yes|

# Food Entity
Creating food requires authorization. Hence, JWT must be included in the header.
| Http Method | Path | Description | Example | Bearer Token |
|:-----------:|:----:|-------------|---------|:------------:|
|POST|/api/v1/food|Adds food to the database|{<br/> &nbsp; "name": "Pasta",<br/> &nbsp; "ingredients": "Penne, Veggies, Salt",<br/> &nbsp; "cuisine": "Italian"<br/> &nbsp;}|Yes|
|GET|/api/v1/food|Fetches all the food from the database.|<div align="center">No Body Required</div>|Yes|
|GET|/api/v1/food/{id}|Fetches food with a specific id from the database.|<div align="center">No Body Required</div>|Yes|
|PUT|/api/v1/food/{id}|Updates the food with the details provided in the body.|{<br/> &nbsp; "name": "Rice",<br/> &nbsp; "ingredients": "rice, water, salt",<br/> &nbsp; "cuisine": "Indian"<br/> &nbsp;}|Yes|
|DELETE|/api/v1/food/{id}|Deletes food with the id mentioned in the path variable.|<div align="center">No Body Required</div>|Yes|

# Menu Entity
Creating menu requires authorization. Hence, JWT must be included in the header.
| Http Method | Path | Description | Example | Bearer Token |
|:-----------:|:----:|-------------|---------|:------------:|
|POST|/api/v1/menu//restaurant/{restaurantId}/food/{foodId}|Adds menu to the database and links to the restaurant and food with their respective id’s mentioned in the path|{<br/> &nbsp; "price": 15,<br/> &nbsp; "calories": 100<br/> &nbsp;}|Yes|
|GET|/api/v1/menu|Fetches all menu from the database.|<div align="center">No Body Required</div>|Yes|
|GET|/api/v1/menu/{id}|Fetches menu with a specific id from the database.|<div align="center">No Body Required</div>|Yes|
|PUT|/api/v1/menu/{id}|Updates the menu with the details provided in the body.|{<br/> &nbsp; "price": 30,<br/> &nbsp; "calories": 150<br/> &nbsp;}|Yes|
|DELETE|/api/v1/menu/{id}|Deletes menu with the id mentioned in the path variable.|<div align="center">No Body Required</div>|Yes|
