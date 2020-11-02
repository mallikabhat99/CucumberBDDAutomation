Feature: Application Login

@WebTest
Scenario: Home page default login
Given User is on Netbanking landing page
When User login into application with username and password
Then Home page is populated
And Cards are displayed is "true"

@MobileTest
Scenario: Home page default login browser - arg
Given User is on Netbanking landing page
When User login into application with "jin" and "jan"
Then Home page is populated
And Cards are displayed is "true"

@MobileTest
Scenario: Home page default login failure - arg
Given User is on Netbanking landing page
When User login into application with "pin" and "pan"
Then Home page is populated
And Cards are displayed is "false"

@WebTest
Scenario: Home page default login browser - data table
Given User is on Netbanking landing page
When User signup with following details
| jenny | dsouza | India | 560061 |
| col1 | col2 | India | 560061 |
Then Home page is populated
And Cards are displayed is "true"


Scenario Outline: Home page default login browser data parmeterization
Given User is on Netbanking landing page
When User login in to application with <Username> and <Password>
Then Home page is populated
And Cards are displayed is "true"

Examples:
|Username  | Password  |
|user1     | pass1    |
|user2     | pass2    |
|user3     | pass3    |
|user4     | pass4    |