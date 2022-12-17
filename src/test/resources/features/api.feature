Feature: Api tests

  @ASP-24
  Scenario: Performing POST request for adding new student to DB
    Then Get all students
    Then I add new student to db with fields with end point "/api/school/resources/students"

  @ASP-26
  Scenario: Performing DELETE request for deleting existing student
    Then I add new student to db with fields with end point "/api/school/resources/students"
    Then I delete existing student with _id parameter with end point "/api/school/resources/students/"
