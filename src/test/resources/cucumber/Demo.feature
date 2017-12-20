@successful
@feature_one
Feature: Demo of thedemosite

	@scenario_one
	Scenario: client will launch the demo site and enter user ID and passward to add user to demo site
	Given Client will launch the add user demo site http://thedemosite.co.uk/addauser.php
	When When User Enters Credentials to Login
	|UserNameValue|PasswordValue|
	|Nagesh|password|
	|Chetan|passwd|
	And to validate the below deatils
	|UserNameValue|PasswordValue|
	|Nagesh|password|
	|Chetan|passwd|
	Then Close the add user window
	