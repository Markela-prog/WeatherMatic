package lt.viko.eif.emarkevicius.WeatherMatic.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import io.restassured.response.Response;

public class InvalidLocationTest {
    private WeatherStepDefinitions weatherSteps;
    private Response response;

    @Given("the weather API is running")
    public void theWeatherAPIIsRunning() {
        weatherSteps = new WeatherStepDefinitions();
        weatherSteps.checkAPIStatus();
    }

    @When("I request weather data for an invalid location")
    public void iRequestWeatherDataForAnInvalidLocation() {
        weatherSteps.requestWeatherData("invalid_location");
        response = weatherSteps.getResponse();
    }

    @Then("the error response status code should be {int}")
    public void theErrorResponseStatusCodeShouldBe(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("an appropriate error message should be provided")
    public void anAppropriateErrorMessageShouldBeProvided() {
        weatherSteps.checkResponseErrorMessage();
    }
}

