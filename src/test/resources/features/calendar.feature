Feature: Calendar page tests
  Background: Navigate to Calendar Page
    Given I open url of homepage
    When I click a button Calendar

  @US1015 @smoke @regression
  Scenario: Choosing date from calendar
    When I click a button endDateInput
    When I click a button endDateCalendar
    When I click a button Submit
    Then Text will display 1 day difference