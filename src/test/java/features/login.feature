Feature: Test the Loginpage of website 
#https://www.saucedemo.com/

#Background:
#Given validate the browser
#When browser is triggered
#Then check if the browser is started

@RegTest
Scenario: Login as a Standard  User
Given website is launched
When form is displayed
And enter valid credentials for "standard_user" and "secret_sauce"
Then product page must be displayed

@SmokeTest
Scenario: Login as a User
Given website is launched
When form is displayed
And enter valid credentials for users  
     | standard_user | secret_sauce |
     |  locked_out_user | secret_sauce |
     | problem_user | secret_sauce |
     | performance_glitch_user | secret_sauce | 
Then product page must be displayed

@RegTest @SmokeTest
Scenario Outline:Login as a User
Given website is launched
When form is displayed
And enter valid credentials for users with <username> and <password>
Then product page must be displayed

Examples:
|username |password |
| standard_user | secret_sauce |
| locked_out_user | secret_sauce |
| problem_user | secret_sauce |
| performance_glitch_user | secret_sauce |