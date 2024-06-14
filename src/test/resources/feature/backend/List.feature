Feature: Listing Data

  Scenario : Get User Listing
    Given user on test environment
    When user get list user
    Then user get http request status code of "200"