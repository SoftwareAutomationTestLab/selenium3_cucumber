Feature: Test the Loginpage of website 
#https://www.saucedemo.com/

#Background:
#Given validate the browser
#When browser is triggered
#Then check if the browser is started

@RegTest
Scenario Outline: Login as a  User
Given Test website is launched
When login form is displayed
And enter valid test credentials for <username> and <password>
Then products page must be displayed
Examples:
|username |password |
| standard_user | secret_sauce |
| locked_out_user | secret_sauce |
| problem_user | secret_sauce |
| performance_glitch_user | secret_sauce |