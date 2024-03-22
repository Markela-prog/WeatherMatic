Feature: Weather Temperature in Celsius

  Scenario: Retrieve Weather Temperature in Celsius
    Given the API is running
    When I request weather data for "Paris" in Celsius
    Then check the Celsius response status code 200
    And the response should include the main temperature in Celsius