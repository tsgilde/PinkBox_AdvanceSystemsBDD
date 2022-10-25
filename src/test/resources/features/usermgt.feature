Feature: User Mgt page scenarios
  Background: Navigate to User-Mgt Page
    Given I open url of homepage
    When I click nav button "User-Mgt"

  @US4001 @regression
  Scenario: User-Mgt page title test
    Then Verify title of the page is Register New User

  @US4002
  Scenario: Login button test
    Then Verify Login button is present

  @US4004
  Scenario: Verify following input fields are displayed on the page
    Then Verify "First Name" input field is displayed
    Then Verify "Last Name" input field is displayed
    Then Verify "Phone Number" input field is displayed
    Then Verify "E-mail" input field is displayed

  @US4004b
  Scenario: Verify following input fields are displayed on the page 2
    Then Verify following input fields are displayed:
      | First Name   |
      | Last Name    |
      | Phone Number |
      | E-mail       |

  @US4010
  Scenario: Add new User to staging table
    When I fill out user registration form with following info:
      | First Name   | John                  |
      | Last Name    | Wick                  |
      | Phone Number | 666-666-6666          |
      | E-mail       | j.wick@contractor.gov |
      | role         | Mentor                |
    And I click a button "Submit"
