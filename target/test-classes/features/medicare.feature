Feature:Medicare UI Validation

@Registration
Scenario:Validate User Registration
Given user click SignUp button
When user enters basic information and navigates to Billing page
|Kiki|cat|jh@gmail.com|1112223334|hello123|
And user enters address information and navigates to confirmation screen
|007|1st cross|CityX|111|StateX|CountryX|
And user clicks confirm button
And user click Login Here button
And user enter username and password and clicks Login button
|jh@gmail.com|hello123|
Then  "Medicare - Home" page should be displayed

@User
Scenario:Validate Paracetamol Product Purchase
When users clicks View button for Paracetamol
And user clicks Add to Cart
And user clicks Checkout
And user selects saved shippig address
And user enters credit card informartion and click pay
|1234567890|99|3000|000| 
Then  "Your Order is Confirmed!!" message should be displayed

@Database
Scenario:Add a category and verify in database
Given user logged in with admin username "vk@gmail.com" and password "admin"
When user click on Manage Product and selects Add New Category
And user provides Category name and description and saves it
|Mycategory001|MyCategorydesc002|
Then verify category "Mycategory001" and description "MyCategorydesc002" should be saved to database


