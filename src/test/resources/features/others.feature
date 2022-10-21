Feature: Others tests
  Background: Navigate to Others Page
    Given I open url of homepage
    When I click a button Others

  @regression @US2001
  Scenario: Disabled button is working as expected
    Then Verify buttons is disabled