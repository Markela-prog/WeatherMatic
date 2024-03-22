Feature: Weather Information

  Scenario: Retrieve sunrise and sunset times for a city
    Given ensure the weather API is running
    When I request weather information for "London"
    Then the weather information response status code should be 200
    And the response should include the sunrise and sunset times