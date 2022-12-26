Feature: Services Page Tests

  Background: Navigate to Home page
    Given I open url to homepage
    Then I click the button "Services"

    @ASP-34
    Scenario Outline: Should be 4 division displayed for now on this page
      Then I click link  "<division>"
      Examples:
      |division|
      |Finance|
      |Information Technology|
      |Healthcare            |
      |Government Projects   |

      @ASP-35
      Scenario: should be enable user navigate throught each existing division and go back to Services
        Then I click in the in ech division and go back to services

        @ASP-37
        Scenario: Each Divion page should have following:
          Then I click in each Divion and verify header, main image, description and a quote



