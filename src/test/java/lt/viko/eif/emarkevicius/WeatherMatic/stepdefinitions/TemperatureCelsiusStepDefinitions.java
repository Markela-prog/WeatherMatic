package lt.viko.eif.emarkevicius.WeatherMatic.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class TemperatureCelsiusStepDefinitions {
    private Response response;
    private RequestSpecification request;
    private WeatherStepDefinitions weatherSteps;

    public TemperatureCelsiusStepDefinitions(WeatherStepDefinitions weatherSteps) {
        this.weatherSteps = weatherSteps;
    }

    @Given("ensure the API is running")
    public void ensureAPIRunning() {
        weatherSteps.checkAPIStatus();
    }

    @When("I request weather data for {string} in Celsius")
    public void requestWeatherDataInCelsius(String city) {
        weatherSteps.setRequestQueryParam("units", "metric"); // Set the units to Celsius
        weatherSteps.requestWeatherData(city);
        response = weatherSteps.getResponse();
    }

    @Then("check the Celsius response status code {int}")
    public void checkCelsiusResponseStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("the response should include the main temperature in Celsius")
    public void checkResponseIncludesTemperatureInCelsius() {
        Double temperature = response.jsonPath().getDouble("main.temp");
        Assert.assertNotNull(temperature);
    }
}