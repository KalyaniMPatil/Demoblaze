Feature: Login functionality checking

Background:
Given User on the Login page

Scenario: Verify login function using valid credentials
	When User entered username and password
	Then User should logged in successfully
	
Scenario: Verify login function using blank credentials
	When User entered blank credentials for login
	Then User should get an error for login
	
Scenario: Verify login function using blank username
	When User entered blank username for login
	Then User should get an error for login
	
Scenario: Verify login function using blank password
	When User entered blank password for login
	Then User should get an error for login