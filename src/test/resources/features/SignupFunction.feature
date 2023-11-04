Feature: Signup functionality checking

Background:
Given User on the Signup page

Scenario: Verify Signup function using valid credentials
	When User entered valid username and password
	Then User should get signup success message
	
Scenario: Verify Signup function using blank credentials
	When User entered blank credentials for signup
	Then User should get an error for signup

Scenario: Verify Signup function using blank username
	When User entered blank username for signup
	Then User should get an error for signup
	
Scenario: Verify Signup function using blank password
	When User entered blank password for signup
	Then User should get an error for signup
	
