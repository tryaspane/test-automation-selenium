Feature: Login
  Scenario Outline: User employee login
    Given user on test environment
    When user generate token using "<email>" and "<password>" credential account
    Then user get http request status code of "200"
    Examples:
      | email              | password |
      | try.admin@mail.com | 12345678 |
