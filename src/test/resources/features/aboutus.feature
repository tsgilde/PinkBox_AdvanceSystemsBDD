Feature: Contact Us Page Tests

  Background: Navigate to Home page
    Given I open url to homepage
    Then I click the navigation "About Us"

  @ASP-33
  Scenario Outline: Test about us page : Why choose us
    Then Verify the section should have four headers with description "<text>"
    Examples:
    | text           |
    | Evaluate Resume|
    | Interview      |
    | Screening      |
    | Process Done   |


  @ASP-30
  Scenario:There should be a section with header Why Choose Us
    Then I verify if "Why Choose Us" is display
    Then I verify if subtitle "On time Services","Experienced Team","Good Track Records" is displayed
