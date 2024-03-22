/**
 * The CucumberTestRunner class is used to run Cucumber tests for the WeatherMatic application.
 * It configures the Cucumber options and sets up the necessary glue and feature paths.
 */
package lt.viko.eif.emarkevicius.WeatherMatic.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * The CucumberTestRunner class is the entry point for running Cucumber tests.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "lt.viko.eif.emarkevicius.WeatherMatic.stepdefinitions",
        features = "src/test/java/lt/viko/eif/emarkevicius/WeatherMatic/features"
)
public class CucumberTestRunner {
}