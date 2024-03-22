Feature: Weather API
  Scenario: Retrieve weather data for a valid city
    Given the API is running
    When I request weather data for "London"
    Then the response status code should be 200
    And the response should contain weather data for "London"
    And the response should include the main temperature
    And the response should include weather description
    And the response should include sunrise and sunset times
