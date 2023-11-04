Feature: Contact functionality checking

Background:
Given User on the Contact page

Scenario: Verify Contact function using valid credentials
	When User entered valid Email Name and Message
	Then User should get thank you message for contacting
	
Scenario: Verify Contact function using Blank credentials
	When Email Name and Message credentials are Blank
	Then User should get Error Message for blank details
	
Scenario: Verify Contact function with Blank Contact email id field
	When User entered contact name message and keep email field blank
	Then User should get Error Message for blank details
	
Scenario: Verify Contact function with Blank Contact name field
	When User entered contact email message and keep name field blank
	Then User should get Error Message for blank details
	
Scenario: Verify Contact function with Blank message field
	When User entered contact email name and keep message field blank
	Then User should get Error Message for blank details