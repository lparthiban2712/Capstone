Feature:Medicare UI Validation

@Registration
Scenario:Validate User Registration
Given user click SignUp button
When user enters basic information and navigates to Billing page
|Kiki|cat|jji@gmail.com|1112223334|hello123|
And user enters address information and navigates to confirmation screen
|007|1st cross|CityX|111|StateX|CountryX|
And user clicks confirm button
And user click Login Here button
And user enter username and password and clicks Login button
|jji@gmail.com|hello123|
Then  "Medicare - Home" page should be displayed

@Functional
Scenario:Validate Paracetamol Product Purchase
When users clicks View button for Paracetamol
And user clicks Add to Cart
And user clicks Checkout
And user selects saved shippig address
And user enters credit card informartion and click pay
|1234567890|99|3000|000| 
Then  "Your Order is Confirmed!!" message should be displayed

