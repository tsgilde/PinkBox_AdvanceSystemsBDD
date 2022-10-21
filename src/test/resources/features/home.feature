Feature: Home Page tests
  Background: Navigate to Home Page
    Given I open url of homepage

  @regression @US1021
  Scenario: Test header of the home page
    Then Verify header text is Automation with Selenium

  @US1022 @smoke @regression
  Scenario : Test nav buttons are displayed
    Then Verify button Home is displayed
    Then Verify button Calendar is displayed
    Then Verify button UserMgt is displayed
    Then Verify button Others is displayed
    Then Verify button Tables is displayed
    Then Verify button Synchronization is displayed
    Then Verify button iFrames is displayed
