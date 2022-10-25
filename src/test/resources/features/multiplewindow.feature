Feature: Multiple Window Page Tests

  Background: Navigate to Multiple-window Page
    Given I open url of homepage
    When I click nav button "Multiple Window"

    @9001
  Scenario: In Multiple-window page, verify following buttons are enabled
      Then Verify "Launch TLA" button is enabled
      Then Verify "Launch Google" button is enabled
      Then Verify "Launch Facebook" button is enabled

  @US9001b
  Scenario: Verify social media buttons are enabled 2
    Then Verify following link texts are displayed:
      | Launch TLA      |
      | Launch Google   |
      | Launch Facebook |

  @US9001c
  Scenario Outline: Verify social media buttons are enabled using scenario Outline
    Then Verify link text "<button>" is displayed
    Examples:
      | button          |
      | Launch TLA      |
      | Launch Google   |
      | Launch Facebook |
