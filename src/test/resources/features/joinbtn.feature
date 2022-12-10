Feature: Reset search filter option
  Background: Navigate to JOIN NOW button
    Given I open url of homepage



  @ASP-08
  Scenario: There should be a "JOIN NOW" button above the main content of the home page
    Then I verify the button is displayed "Join Now"


  @ASP-08b
  Scenario: Button should take me to "Join Us" page
    Then I click the button "Join Now"
    And I verify if it took me to "Join Us" page

