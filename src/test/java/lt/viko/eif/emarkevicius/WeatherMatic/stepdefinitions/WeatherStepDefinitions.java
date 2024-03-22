/**
 * The stepdefinitions package contains the step definitions for Cucumber scenarios related to weather data retrieval.
 * It includes classes that define the behavior of each step in the scenarios.
 */
package lt.viko.eif.emarkevicius.WeatherMatic.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

/**
 * The WeatherStepDefinitions class contains step definitions for weather-related scenarios.
 * It defines the behavior of each step in the scenarios using Cucumber annotations.
 */
public class WeatherStepDefinitions {
    private Response response;
    private RequestSpecification request;

    public Response getResponse() {
        return response;
    }
    public RequestSpecification getRequest() {
        return request;
    }

    /**
     * Sets up the base URI for the API and initializes the request specification.
     * This step is executed before each scenario.
     */
    @Given("the API is running")
    public void checkAPIStatus() {
        RestAssured.baseURI = "http://localhost:8080";
        request = RestAssured.given();
    }

    /**
     * Sends a request to retrieve weather data for the specified city.
     *
     * @param city the name of the city for which weather data is requested
     */
    @When("I request weather data for {string}")
    public void requestWeatherData(String city) {
        response = request.get("/weather/" + city);
    }

    /**
     * Checks if the response status code matches the expected status code.
     *
     * @param expectedStatusCode the expected status code
     */
    @Then("the response status code should be {int}")
    public void checkResponseStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    /**
     * Checks if the response contains weather data for the expected city.
     *
     * @param expectedCity the expected city name
     */
    @And("the response should contain weather data for {string}")
    public void checkResponseContainsCity(String expectedCity) {
        String actualCity = response.jsonPath().getString("name");
        Assert.assertEquals(expectedCity, actualCity);
    }

    /**
     * Checks if the response includes the main temperature.
     */
    @And("the response should include the main temperature")
    public void checkResponseIncludesTemperature() {
        Assert.assertNotNull(response.jsonPath().get("main.temp"));
    }

    /**
     * Checks if the response includes the weather description.
     */
    @And("the response should include weather description")
    public void checkResponseIncludesWeatherDescription() {
        Assert.assertNotNull(response.jsonPath().get("weather[0].description"));
    }

    /**
     * Checks if the response includes sunrise and sunset times.
     */
    @And("the response should include sunrise and sunset times")
    public void checkResponseIncludesSunriseAndSunset() {
        Assert.assertNotNull(response.jsonPath().get("sys.sunrise"));
        Assert.assertNotNull(response.jsonPath().get("sys.sunset"));
    }

    public void checkResponseErrorMessage() {
    }
    public void setRequestQueryParam(String param, Object value) {
        request.queryParam(param, value);
    }

}