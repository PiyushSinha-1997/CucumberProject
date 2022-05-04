Feature: Login Page feature
In order to test the application
As a registered user
I want to specify feature of Login Page

Scenario: Login Page title
Given user is on login page
When user gets the title of page
Then page title should be "Login - My Store"

Scenario: Forgot your password link
 Given user is on login page
 Then Forgot password link should be displayed
 
 Scenario: Login with valid credential
 Given user is on login page
 When user enter valid username "piyushgolu9199@gmail.com"
 And user enter valid password "Piyush@1997"
 And user click on login button
 Then user gets the title of page
 And page title should be "My account - My Store"