
Feature: Login page feature
@Smoke
Scenario: Login page title
Given user is on Login page
When user gets the title of the page
Then page title should be "Login - My Store"
@Smoke
Scenario: Forget Password link
Given user is on Login page
Then forgot your password link should be displayed
@Regression @Skip
Scenario: Login with correct credentials
Given user is on Login page
When user enters username "dec2020secondbatch@gmail.com"
And user enters password "Selenium@12345"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Store"