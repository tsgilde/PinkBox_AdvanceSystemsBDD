Feature: Home page tests

  Background: Navigate to Home page
    Given I open url to homepage

  @ASP-3 @smoke
  Scenario: I would like to display our address and phone number under the main navigation bar
    When I verify the home page is display the contact info

  @ASP-6 @smoke @regression
  Scenario: Test header of the home page
    Then Verify header text is "Advance Systems - Home"

  @ASP-7a @regression
  Scenario: Test navigation bar buttons are displayed
    Then Verify button "Get Support" is displayed
    Then Verify button "Job Career" is displayed
    Then Verify button "Feedback" is displayed

  @ASP-7b @regression
  Scenario Outline: Test language selection in navigation bar
    When I click on language button
    Then I should see "<Languages>" in dropdown menu
    Examples:
      | Languages |
      | English   |
      | Spanish   |
      | French    |

  @ASP-10 @Regression
  Scenario Outline: Verify Social media options
    When I click a "<social media link>" button
    Then It should take me to corresponding page. "<social media name>"
    Examples:
      | social media link     | social media name |
      | https://facebook.com  | Facebook          |
      | https://twitter.com   | Twitter           |
      | https://instagram.com | Instagram         |
      | https://linkedin.com  | LinkedIn          |

  @ASP-11 @smoke
    Scenario Outline: Verify What to expect section
    Then I verify "<what to expect>"  section is displayed
    Examples:
    | what to expect                |
    | Leadership Development        |
    | Capability Building           |
    | Rewards & Benefits            |
    | Employee & Employer           |
    | Relations                     |
    | Excellent Customer Service    |

  @ASP-13 @regression
  Scenario: Verify above the footer there should be displayed company names in 1 row.
    Then Verify company names is displayed in 1 row.

  @ASP-15
  Scenario Outline:  Verify practice website destination url
    When I click link text "<linkText>"
    Then Verify destination window has url as "<URL>"
    Examples:
      | linkText   | URL                                                                 |
      | Home       | https://tla-batch-6.github.io/advance-systems-test-b6/index.html    |
      | About Us   | https://tla-batch-6.github.io/advance-systems-test-b6/about.html    |
      | Services   | https://tla-batch-6.github.io/advance-systems-test-b6/services.html |
      | Clients    | https://tla-batch-6.github.io/advance-systems-test-b6/clients.html  |
      | Contact Us | https://tla-batch-6.github.io/advance-systems-test-b6/contact.html  |





