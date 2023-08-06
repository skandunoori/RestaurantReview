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
Creating User doesnt need authentication. So no JWT has to be included for creating a user.

HTTP Method	Path	Description	Example Body	Requires Bearer Token
POST	/api/v1/user/	Adds user to DB. Expects the user to be present in the body.	
{  
    "userName":"Kaushik",
    "password":"Test",
    "firstName":"Kaushik",
    "lastName":"Boora",
    "dob":"1998-12-25",
    "gender": "MALE",
    "contact":{
        "phoneNumber": "+1 8577305657",
        "email":"boora.k@northeastern.edu"
    },
    "address":{
        "street": "9 Dalwood Street",
        "apt": "Unit A",
        "city":"Boston",
        "state": "MA",
        "country": "United States of America",
        "pinCode": "500018"
    }

}
No
GET	/api/v1/user	Fetches all the users in the Database.	No Body Required	No
GET	/api/v1/user/{userId}	Fetches the user whose Id is mentioned in the PathVariable.	No Body Required	No
PUT	/api/v1/user/{userId}	Updates the user with new user provided in the body.	
{
 "firstName":"Boora",
"lastName":"Kaushik",
"dob":"1998-12-10",
"gender": "MALE"
}
No
DELETE	/api/v1/user/{userId}	Deletes the user whose id is provided in the path variable.	No Body Required	No
Restaurant Entity
This Resource requires users to be authenticated. JWT must be included in the header.

HTTP Method	Path	Description	Example Body	Requires Bearer Token
POST	/api/v1/restaurant/	Adds restaurant to DB. Expects the restaurant to be present in the body.	
{
    "name":"Kaushik Restaurent",
    "cusine":"Indian",
    "contact":{
        "phoneNumber": "+1 8575551234",
        "email":"boora.k@northeastern.edu"
    },
    "address":{
        "street": "9 Dalwood Street",
        "apt": "Unit A",
        "city":"Boston",
        "state": "MA",
        "country": "United States of America",
        "pinCode": "500018"
    }
}
Yes
GET	/api/v1/restaurant	Fetches all the restaurants in the Database.	No Body Required	Yes
GET	/api/v1/restaurant/{restaurantId}	Fetches the restaurant whose Id is mentioned in the PathVariable.	No Body Required	Yes
PUT	/api/v1/restaurant/{restaurantId}	Updates the restaurant with new restaurant provided in the body.	
{
    "name":"Boora Restaurent",
    "cusine":"Kaushik"
}
YES
DELETE	/api/v1/restaurant/{restaurantId}	Deletes the restaurant whose id is provided in the path variable.	No Body Required	YES
Address Entity
This Resource requires users to be authenticated. JWT must be included in the header.

HTTP Method	Path	Description	Example Body	Requires Bearer Token
POST	/api/v1/address/restaurant/{restaurantId}	Updates the Address of a Restaurant by creating a new address.	
 {
    "street": "9 Dalwood Street",
    "apt": "Unit B",
    "city": "Boston",
    "state": "MA",
    "country": "United States of America",
    "pinCode": "500018"
}
YES
POST	/api/v1/address/user/{userId}	Updates the Address of a User by creating a new address.	
  {
    "street": "9 Dalwood Street",
    "apt": "Unit B",
    "city": "Boston",
    "state": "MA",
    "country": "United States of America",
    "pinCode": "500018"
}
YES
PUT	/api/v1/address	Updates the address with the provided address	
{
    "street": "9 Dalwood Street",
    "apt": "Unit B",
    "city": "Boston",
    "state": "MA",
    "country": "United States of America",
    "pinCode": "500018"
}
YES
GET	/api/v1/address	Fetches all the addresses in the Database.	No Body Required	YES
GET	/api/v1/address/{addressId}	Fetches the address whose Id is mentioned in the PathVariable.	No Body Required	YES
Contact Entity
This Resource requires users to be authenticated. JWT must be included in the header.

HTTP Method	Path	Description	Example Body	Requires Bearer Token
POST	/api/v1/contact/restaurant/{restaurantId}	Updates the Contact of a Restaurant by creating a new contact.	
{
    "phoneNumber":"+1 8572305117",
    "email":"kaushikboora2@gmail.com"
}
YES
POST	/api/v1/contact/user/{userId}	Updates the Contact of a User by creating a new contact.	
{
    "phoneNumber":"+1 8572305117",
    "email":"kaushikboora2@gmail.com"
}
YES
PUT	/api/v1/contact	Updates the contact with the provided contact	
{
    "phoneNumber":"+1 8572305117",
    "email":"kaushikboora2@gmail.com"
}
YES
GET	/api/v1/contact	Fetches all the contacts in the Database.	No Body Required	YES
GET	/api/v1/contact/{contactId}	Fetches the contact whose Id is mentioned in the PathVariable.	No Body Required	YES
Comment Entity
This Resource requires users to be authenticated. JWT must be included in the header.

HTTP Method	Path	Description	Example Body	Requires Bearer Token
POST	/api/v1/comment/restaurant/{restaurantId}/user/{userId}	Adds comment to DB and links it with User and Restaurant. Expects the comment to be present in the body and restaurant id and user id provided in the path variable.	
{
    "comment":"Hello !Ndia"
}
YES
GET	/api/v1/comment	Fetches all the comments in the Database.	No Body Required	YES
GET	/api/v1/comment/{commentId}	Fetches the comment whose Id is mentioned in the PathVariable.	No Body Required	YES
PUT	/api/v1/comment/{commentId}	Updates the comment with new comment provided in the body.	
{
    "comment":"Hello!"
}
YES
DELETE	/api/v1/comment/{commentId}	Deletes the comment whose id is provided in the path variable.	No Body Required	YES
Rating Entity
This Resource requires users to be authenticated. JWT must be included in the header.

HTTP Method	Path	Description	Example Body	Requires Bearer Token
POST	/api/v1/rating/restaurant/{restaurantId}/user/{userId}	Adds rating to DB and links it with User and Restaurant. Expects the rating to be present in the body and restaurant id and user id provided in the path variable.	
{
    "value": 4
}
YES
GET	/api/v1/rating	Fetches all the ratings in the Database.	{}	YES
GET	/api/v1/rating/{ratingId}	Fetches the rating whose Id is mentioned in the PathVariable.	{}	YES
PUT	/api/v1/rating/{ratingId}	Updates the rating with new rating provided in the body.	
{
    "value": 3
}
YES
DELETE	/api/v1/rating/{ratingId}	Deletes the rating whose id is provided in the path variable.	{}	YES
Food Entity
This Resource requires users to be authenticated. JWT must be included in the header.

HTTP Method	Path	Description	Example Body	Requires Bearer Token
POST	/api/v1/food/	Adds food to DB.	
{
    "name":"Biryani",
    "ingredients":"Samolina, Urad dal, Baking soda, Salt",
    "cusine":"Indian"
}
YES
GET	/api/v1/food	Fetches all the foods in the Database.	No Body Required	YES
GET	/api/v1/food/{foodId}	Fetches the food whose Id is mentioned in the PathVariable.	No Body Required	YES
PUT	/api/v1/food/{foodId}	Updates the food with new food provided in the body.	
{
    "name":"Biryani",
    "ingredients":"Urad dal, Baking soda, Salt",
    "cusine":"Indian"
}
YES
DELETE	/api/v1/food/{foodId}	Deletes the food whose id is provided in the path variable.	No Body Required	YES
MenuItem Entity
This Resource requires users to be authenticated. JWT must be included in the header.

HTTP Method	Path	Description	Example Body	Requires Bearer Token
POST	/api/v1/menu-item/restaurant/{restaurantId}/food/{foodId}	Adds menuItem to DB and links it with Food and Restaurant. Expects the menuItem to be present in the body and restaurant id and Food id provided in the path variable.	
{
    "price": 30.0,
    "calories":15.67
}
YES
GET	/api/v1/menu-item	Fetches all the menuItems in the Database.	{}	YES
GET	/api/v1/menu-item/{menuItemId}	Fetches the menuItem whose Id is mentioned in the PathVariable.	{}	YES
PUT	/api/v1/menu-item/{menuItemId}	Updates the menuItem with new menuItem provided in the body.	
{
    "price": 76.0,
    "calories":15.67
}
YES
DELETE	/api/v1/menu-item/{menuItemId}	Deletes the menuItem whose id is provided in the path variable.	{}	YES
MenuItem Entity
Creates a JWT that is valid for 12 hours.

HTTP Method	Path	Description	Example Body	Requires Bearer Token
POST	/login	Takes username and password of a user, authenticates user and if valid creates a JWT token that is valid for 12 hrs since it is created.	
{
            "userName": uName,
            "password": "Test@123"
        }
Not Applicable
Documentation
Implemented Documentation using Java Docs. Please find documentation of all the classes under docs directory.
