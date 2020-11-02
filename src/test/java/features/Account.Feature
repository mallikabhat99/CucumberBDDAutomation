Feature: Application Account Feature

Background:
Given Validate the browser
When Browser is triggerd 
Then Check if browser is started
#Background is command pre-req for all test case

@PortalTest
Scenario: Home page default login
Given User is on Netbanking landing page
When User login into application with username and password
Then Home page is populated
And Cards are displayed is "true"

@PortalTest
Scenario: Home page default login
Given User is on Netbanking landing page
When User login into application with username and password
Then Home page is populated
And Cards are displayed is "true"