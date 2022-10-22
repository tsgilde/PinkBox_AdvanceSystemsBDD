Feature: Multiple Window Page Tests

  Background: Navigate to Multiple-window Page
    Given I open url of homepage
    When I click a button Multiple-window

    @Test2
  Scenario: In Multiple-window page, verify following buttons are enabled
      Then Verify Launch TLA button is enabled
      Then Verify Launch Google button is enabled
      Then Verify Launch Facebook button is enabled