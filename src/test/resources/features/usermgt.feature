Feature: User Mgt page scenarios
  Background: Navigate to User-Mgt Page
    Given I open url of homepage
    When I click a button User-Mgt

  @US4001 @regression
  Scenario: User-Mgt page title test
    Then Verify title of the page is Register New User

  @US4002
  Scenario: Login button test
    Then Verify Login button is present