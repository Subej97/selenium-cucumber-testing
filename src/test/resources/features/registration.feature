Feature: User Registration

  Scenario: Successful user registration
    Given I am on the registration page
    When I fill in the registration form with valid details
    Then I should see a confirmation message that the account is created

  Scenario: Registration with missing last name
      Given I am on the registration page
      When I fill in the registration form with missing last name
      Then I should see an error message stating that last name is required

    Scenario: Registration with mismatched passwords
      Given I am on the registration page
      When I fill in the registration form with mismatched passwords
      Then I should see an error message stating that passwords do not match

    Scenario Outline: User registers with mismatched passwords
      Given I am on the registration page
      When I fill the form with password "<password>" and confirm password "<confirmPassword>"
      Then I should see an error message stating that passwords do not match2

      Examples:
        | password      | confirmPassword |
        | Password123   | Password321     |
        | TestPass!     | WrongPass!      |


    Scenario: Registration with terms and conditions not accepted
      Given I am on the registration page
      When I fill in the registration form without accepting the terms and conditions
      Then I should see an error message stating that terms and conditions must be accepted
