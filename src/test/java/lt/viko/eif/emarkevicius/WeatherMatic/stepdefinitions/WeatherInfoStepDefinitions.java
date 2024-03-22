package lt.viko.eif.emarkevicius.WeatherMatic.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class WeatherInfoStepDefinitions {
    private Response response;

    @Given("ensure the weather API is running")
    public void ensureWeatherAPIRunning() {
        // No action is required here as it is just a placeholder step
    }

    @When("I request weather information for {string}")
    public void requestWeatherInformation(String city) {
        response = RestAssured.get("/weather/" + city);
    }

    @Then("the weather information response status code should be {int}")
    public void checkWeatherInformationResponseStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should include the sunrise and sunset times")
    public void checkResponseIncludesSunriseAndSunsetTimes() {
        Assert.assertNotNull(response.jsonPath().get("sys.sunrise"));
        Assert.assertNotNull(response.jsonPath().get("sys.sunset"));
    }
}
