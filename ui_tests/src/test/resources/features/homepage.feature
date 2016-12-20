Feature: Testing google homepage
	As a site visitor
	I want to go to the google homepage
	so that I gain quick access to the features of the portal 

@regression
Scenario: homepage load successfully for a new user
	Given user is on internet
	When I load the ubluknetremit page
  	And I am on Homepage
	Then I should see homepage loaded successfully