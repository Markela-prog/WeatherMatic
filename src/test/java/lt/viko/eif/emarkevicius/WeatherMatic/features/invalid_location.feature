Feature: Weather API

  Scenario: Retrieve weather data for an invalid location
    Given the weather API is running
    When I request weather data for an invalid location
    Then the error response status code should be 500
    And an appropriate error message should be provided