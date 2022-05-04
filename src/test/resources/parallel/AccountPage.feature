Feature: Account Page feature
Background: 
Given user has already logged into application
|username|password |
|piyushgolu9199@gmail.com|Piyush@1997|

Scenario: Account Page title
Given user is on Accounts Page
When user gets the title of page
Then page title should be "My account - My Store"

Scenario: Accounts section count
Given user is on Accounts Page
When user gets Accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
Then Accounts section count should be 6