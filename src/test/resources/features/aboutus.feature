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
