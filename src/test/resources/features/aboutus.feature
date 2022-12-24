Feature: Contact Us Page Tests

  Background: Navigate to Home page
    Given I open url to homepage
    Then I click the navigation "About Us"

  @ASP-30
  Scenario: There should be a section with header Why Choose Us
    Then I verify if "Why Choose Us" is display
    Then I verify if subtitle "On time Services","Experienced Team","Good Track Records" is displayed

  @ASP-31a
    Scenario: Test about us page: header of employees
    Then Verify header "Meet Our Experts" is displayed


  @ASP-31b
    Scenario: Test about us page : team
    Then Verify picture of each employee is displayed
    Then Verify title of each employee is displayed
    Then Verify quote of each employee is displayed
    And Verify social media button of each employee is displayed
    | Facebook |
    | Twitter  |
    | Skype    |
    | LinkedIn |

  @ASP-31c
    Scenario Outline: Test social media link
    When I click a social "<social media link>" button
    Then Social media buttons should take to corresponding page "<social media name>"
    Examples:
      | social media link     | social media name |
      | https://facebook.com  | Facebook          |
      | https://twitter.com   | Twitter           |
      | https://skype.com     | Skype             |
      | https://linkedin.com  | LinkedIn          |






  @ASP-33
  Scenario Outline: Test about us page : Why choose us
    Then Verify the section should have four headers with description "<text>"
    Examples:
    | text           |
    | Evaluate Resume|
    | Interview      |
    | Screening      |
    | Process Done   |

