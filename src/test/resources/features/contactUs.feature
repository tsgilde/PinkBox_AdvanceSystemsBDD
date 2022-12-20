Feature: Contact Us Page Tests

  Background: Navigate to Home page
    Given I open url to homepage
    Then I click the navigation "Contact Us"

  @ASP-38 @regression
  Scenario: Verify a form where user can fill out their information and message to send a request.
    Then Verify following input fields are displayed:
      | Your Name*      |
      | Phone Number *  |
      | Choose Service  |
      | Your Message... |
    Then I verify "Submit Now" button is displayed