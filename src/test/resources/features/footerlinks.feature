Feature: social media buttons displayed in the footer section


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
