Feature: Home page tests

  @US1021 @regression
  Scenario: Test header of the home page
    Given I open url of homepage
    Then Verify header text is "Automation with Selenium"

  @US1022 @regression @smoke
  Scenario: Test nav buttons are displayed
    Given I open url of homepage
    Then Verify button "Home" is displayed
    Then Verify button "Calendar" is displayed
    Then Verify button "User-Mgt" is displayed
    Then Verify button "Others" is displayed
    Then Verify button "Tables" is displayed
    Then Verify button "Synchronization" is displayed
    Then Verify button "iFrames" is displayed

