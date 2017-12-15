@successful
@feature_one
Feature: Demo of thedemosite

	@scenario_one
	Scenario Outline: client will launch the demo site and enter user ID and passward to add user to demo site
	Given Client will launch the add user demo site http://thedemosite.co.uk/addauser.php
	When Enter username <UserNameValue> and Enter password <PasswordValue> and Click on Save button
	Then Validate username is <UserNameValue> & password is <PasswordValue>
	And Close the add user window
	
	Examples:
|UserNameValue|PasswordValue|
|Nagesh|password|
|Chetan|passwd|
	
	@scenario_two
	Scenario: client will launch the login demo site and enter valid user ID and passward for succussfull login
	Given Client will launch the login demo site http://thedemosite.co.uk/login.php
	When Enter username Chetan and Enter password passwd and Click on Test Login button
	Then Validate message **Successful Login**
	And Close the login window
	
	@scenario_three
	Scenario: client will launch the login demo site and enter valid user ID and passward for succussfull login
	Given Client will launch the login demo site http://thedemosite.co.uk/login.php
	When Enter username Nagesh and Enter password password and Click on Test Login button
	Then Validate message **Successful Login**
	And Close the login window
