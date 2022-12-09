Feature: The contact info should be displayed in the footer section


  Background: Navigate to Home page
    Given I open url to homepage

    @ASP-14
    Scenario: In the footer section it should be displayed address, phone number, email and hour.
      When Verify contact info is displayed in the footer section:
      |  Address: 10090 Main St, Fairfax, VA |
      |  Phone: +1 703-831-3217            |
      |  Email: info@advancesystems.us    |
      |  Mon to Sat: 9.00 am to 5:00 pm   |
