Feature: Inputs page tests

  Background: Navigate to inputs page
    Given I open url of homepage
    When I click nav button "Inputs"

  @US4010
  Scenario: Contact Us form test
    When I fill out contact us form with following details:
      | first_name | John                     |
      | last_name  | Wick                     |
      | email      | john.wick@contractor.com |
      | phone      | 666-666-6666             |
      | address    | 123 Main st              |
      | city       | NYC                      |
      | state      | New York                 |
      | zip        | 12345                    |
    When I click a button "Send"
    Then Verify text "Thanks for contacting us, we will get back to you shortly." is displayed
