Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User has navigated to Login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username                   |password    |
|ankush1@gmail.com          |ankush1     |
|ankush2@gmail.com          |ankush2     |


Scenario: Login with invalid credentials
Given User has navigated to Login page
When User enters invalid email address into email field
And User enters invalid password "ankush123" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch
 
Scenario: Login with valid email and invalid password
Given User has navigated to Login page
When User enters valid email address "ankush1@gmail.com" into email field
And User enters invalid password "ankush123" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User has navigated to Login page
When User enters valid email address "ankush7989@gmail.com" into email field
And User enters invalid password "ankush1" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User has navigated to Login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch