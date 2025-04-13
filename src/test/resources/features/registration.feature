Feature: User Registration

  Scenario Outline: Successful registration in <browser>
    Given I open the "<browser>" browser
    And I am on the registration page
    When I fill in the registration form with valid details
    Then I should see a confirmation message that the account is created

  Examples:
    | browser  |
    | chrome   |
    | firefox  |

  Scenario Outline: registration with missing last name in <browser>
    Given I open the "<browser>" browser
    And I am on the registration page
    When I fill in the registration form with missing last name
    Then I should see an error message stating that last name is required

  Examples:
    | browser  |
    | chrome   |
    | firefox  |

  Scenario Outline: registration with mismatching passwords in <browser>
        Given I open the "<browser>" browser
        And I am on the registration page
        When I fill in the registration form with mismatched passwords
        Then I should see an error message stating that passwords do not match

  Examples:
          | browser  |
          | chrome   |
          | firefox  |

    Scenario Outline: registration without accepting the terms and conditions in <browser>
      Given I open the "<browser>" browser
      And I am on the registration page
      When I fill in the registration form without accepting the terms and conditions
      Then I should see an error message stating that terms and conditions must be accepted

    Examples:
      | browser  |
      | chrome   |
      | firefox  |

