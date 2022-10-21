Feature: Pop-Up page tests
  Background: Navigate to Pop-Up page
    Given I open url of homepage
    When I click a button Pop-Up

  @US801
  Scenario: Verify "New Message" header is displayed
    And I click a button Message
    Then Verify header New Message is displayed

  @US802
  Scenario: Verify "BMI Calculator" header is displayed
    And I click a button BMI Calculator
    Then Verify header BMI Calculator is displayed
