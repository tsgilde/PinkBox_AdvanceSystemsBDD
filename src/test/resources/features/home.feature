Feature: Home page tests

  Background: Navigate to Home page
    Given I open url to homepage

  @ASP-3 @smoke
  Scenario: I would like to display our address and phone number under the main navigation bar
    When I verify the home page is display the contact info

  @ASP-4 @regression
  Scenario: Verify Header, description and Read More button under navigation bar is displayed
    Then Verify Header is displayed
    Then Verify description is displayed
    Then Verify if page refresh every 10-15 seconds
    Then User clicks READ MORE button and Verify services page is opened

  @ASP-6 @smoke @regression
  Scenario: Test header of the home page
    Then Verify header text is "Advance Systems - Home"

  @ASP-7a @regression
  Scenario: Test navigation bar buttons are displayed
    Then Verify button "Get Support" is displayed
    Then Verify button "Job Career" is displayed
    Then Verify button "Feedback" is displayed

  @ASP-7b @regression
  Scenario: Test language selection in navigation bar
    When I click on language button
    Then Verify "Languages" selection is displayed

  @ASP-08 @regression
  Scenario: There should be a "JOIN NOW" button above the main content of the home page
    Then I verify the button is displayed "Join Now"

  @ASP-08b @regression
  Scenario: Button should take me to "Join Us" page
    Then I click the button "Join Now"
    And I verify if it took me to "Join Us" page

  @ASP-9 @smoke
  Scenario Outline: Verify navigation options remain visible even after user scrolls down the page
    When I scroll down the home page I verify navigation options are displayed
    When I click the navigation "<option>"
    Then Verify destination window has url as "<URL>"
    Examples:
      | option     | URL                                                                 |
      | Home       | https://tla-batch-6.github.io/advance-systems-test-b6/index.html    |
      | About Us   | https://tla-batch-6.github.io/advance-systems-test-b6/about.html    |
      | Services   | https://tla-batch-6.github.io/advance-systems-test-b6/services.html |
      | Clients    | https://tla-batch-6.github.io/advance-systems-test-b6/clients.html  |
      | Contact Us | https://tla-batch-6.github.io/advance-systems-test-b6/contact.html  |

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
      | what to expect             |
      | Leadership Development     |
      | Capability Building        |
      | Rewards & Benefits         |
      | Employee & Employer        |
      | Relations                  |
      | Excellent Customer Service |

  @ASP-12a
  Scenario: Test testimonials which should be displayed actual testimonials by different people
    Then Verify header text is "Words from our Clients" is displayed

  @ASP-12b
  Scenario: Test the actual testimonials
    Then Verify that each testimonial has message displayed

  @ASP-13 @regression
  Scenario: Verify above the footer there should be displayed company names in 1 row.
    Then Verify company names is displayed in 1 row.

  @ASP-14
  Scenario Outline: In the footer section it should be displayed address, phone number, email and hour.
    When Verify "<contact>" info is displayed in the footer section:
    Examples:
      | contact                             |
      | Address: 10090 Main St, Fairfax, VA |
      | Phone: +1 703-831-3217              |
      | Email: info@advancesystems.us       |
      | Mon to Sat: 9.00 am to 5:00 pm      |

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

  @ASP-16
  Scenario Outline: Test social media buttons in the footer section
    Then Verify social media button "<social media>" is displayed
    Examples:
      | social media |
      | Facebook     |
      | Twitter      |
      | Skype        |
      | LinkedIn     |

  @ASP-17 @smoke
  Scenario Outline: This section should have email input field with a place holder "Email Address…"
    Then I verify "<email input>"  field is displayed
    Examples:
      | email input      |
      | Email Address... |

  @ASP-18
  Scenario: Test move to top button
    When I scroll down to the bottom part of the page
    And I see the button at the bottom right corner of the page
    When I click the bottom right corner
    Then I should see the window move to the top and the button should disappear

  @ASP-19
  Scenario: Copyright text in the bottom is updated
    Then I verify if bottom is updated "Copyright  © 2022 Advance Systems LLC. All Rights Reserved."

  @ASP-20
  Scenario: Test main header section
    Then Verify header text "Welcome to Advance Systems LLC." is displayed
    Then Verify second header text is "Our Mission is simple, deliver very honest recruitment services to every customer." is displayed
    And Verify description text should be displayed under header

    @ASP-29
      Scenario: There should be a main header “Welcome to Advance Systems LLC. ” in the section about us and should cointain name and title.
      Then I click the button "About Us"
      Then I verify the text header "Welcome to Advance Systems LLC."
      And I verify the name and title are displayed

    @ASP-32
    Scenario: I would like to see a header text "we are Recruiting Expeperts" in the page About us
      Then I click the button "About Us"
      Then I verify the text header "We are Recruitment Experts" in the Expert section
      And I click the button "Our Services"
      Then It should take me to the page "Advance Systems - Services"

