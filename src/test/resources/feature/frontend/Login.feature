Feature: Login Feature
  Scenario Outline : Verify user login dashboard
    Given user access "<url>" dashboard
    When user login using username "<username>" and password "<password>"
    Then user can see main dashboard page
    Examples:
      | url         | username | password |
      | ORANGE_HRM  | Admin    | admin123 |
