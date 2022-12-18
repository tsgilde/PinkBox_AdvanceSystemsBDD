Feature: Api tests

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

