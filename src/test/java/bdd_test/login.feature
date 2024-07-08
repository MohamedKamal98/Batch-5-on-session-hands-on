Feature: login

  Scenario Outline: Valid login
    Given navigate to login page
    When  Enter username "<username>"
    And Enter password "<password>"
    And click submit
    Then user is successfully login
    Examples:
    | username| password|
    | Mohamed | pass    |
    | Mohamed1 | pass4    |
    | Mohamed2 | pass3    |

  Scenario: Invalid Login
    Given navigate to login page
    When  Enter Invalid username
    And Enter Invalid password
    And click submit
    Then Error message will appear