Feature: Home page tests

  Background: Navigate to Home page
    Given I open url to homepage

  @US07a @regression
  Scenario: Test navigation bar buttons are displayed
    Then Verify button "Get Support" is displayed
    Then Verify button "Job Career" is displayed
    Then Verify button "Feedback" is displayed

  @US07b @regression
  Scenario Outline: Test language selection in navigation bar
    When I click on language button
    Then I should see "<Languages>" in dropdown menu
    Examples:
      | Languages |
      | English   |
      | Spanish   |
      | French    |



