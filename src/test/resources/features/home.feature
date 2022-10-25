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

  @US1022c @regression @smoke
  Scenario Outline: Test nav buttons are displayed with scenario outline
    Then Verify button "<button name>" is displayed
    Examples:
      | button name     |
      | Home            |
      | Calendar        |
      | User-Mgt        |
      | Others          |
      | Tables          |
      | Synchronization |
      | iFrames         |

  @US1023
  Scenario Outline: Verify practice website destination url
    When I click link text "<linkText>"
    Then Verify destination window has url as "<URL>"
    Examples:
      | linkText      | URL                                     |
      | PHP Travels   | https://phptravels.com/demo/            |
      | Mercury tours | http://ww7.demoaut.com/                 |
      | Internet      | http://the-internet.herokuapp.com/      |
      | E-commerce    | http://automationpractice.com/index.php |


