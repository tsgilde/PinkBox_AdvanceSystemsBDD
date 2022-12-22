Feature: Api tests
  Background: URL
    Given User gets Base URL

  @ASP-21
  Scenario: GET existing courses
    When User send GET request to the endpoint "/programs/devcourse"
    Then User should get status code 200
    When User send GET request to the endpoint "/programs/sdetcourse"
    Then User should get status code 200
#    Then the response should include fields called "_id", "name" and "duration"
    Then the response should include following fields
      | "_id"       |
      | "name"     |
      | "duration" |


  @ASP-22a
  Scenario: Performing POST request for adding a new dev course to DB
    Then Get all dev courses
    Then I add a new dev course to db with fields using endpoint "/api/school/programs/devcourse"

  @ASP-22b
  Scenario: Performing POST request for adding a new sdet course to DB
    Then Get all sdet courses
    Then I add a new sdet course to db with fields using endpoint "/api/school/programs/sdetcourse"

  @ASP-23a
  Scenario: Performing DELETE request for deleting an existing dev course
    Then I add a new dev course to db with fields using endpoint "/api/school/programs/devcourse"
    Then I delete an existing dev course with name using endpoint "/api/school/programs/devcourse"

  @ASP-23b
  Scenario: Performing DELETE request for deleting an existing sdet course
    Then I add a new sdet course to db with fields using endpoint "/api/school/programs/sdetcourse"
    Then I delete an existing sdet course with name using endpoint "/api/school/programs/sdetcourse"

  @ASP-24
  Scenario: Performing POST request for adding new student to DB
    Then Get all students
    Then I add new student to db with fields using end point "/api/school/resources/students"

  @ASP-25
  Scenario: Performing PUT request for updating existing student
    Then I add new student to db with fields using end point "/api/school/resources/students"
    Then I update existing student with _id parameter using end point "/api/school/resources/students/"
    Then I should see an update existing student

  @ASP-26
  Scenario: Performing DELETE request for deleting existing student info
    Then I add new student to db with fields using end point "/api/school/resources/students"
    Then I delete existing student with _id parameter using end point "/api/school/resources/students/"

  @ASP-27
  Scenario: Performing GET request to retrieve bearer token
    Then I send a GET request with username and password using end point "/api/school/departments/gettoken"
    Then Verify error message "Valid username and password required" when send invalid credentials
