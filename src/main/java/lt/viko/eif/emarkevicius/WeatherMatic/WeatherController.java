package lt.viko.eif.emarkevicius.WeatherMatic;

import lt.viko.eif.emarkevicius.WeatherMatic.model.WeatherData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


/**
 * The WeatherController class handles requests related to weather data.
 * It is a Spring Controller that maps HTTP requests to specific methods and returns the requested data.
 */
@Controller
@CrossOrigin(origins = "*") // Allow requests from any origin
public class WeatherController {

    /**
     * The API key used for accessing weather data.
     */
    private static final String API_KEY = "c5500f419d4410434af8fbbe7ef2d5d4";

    /**
     * Handles the "/weather/{city}" path and retrieves weather data for the specified city.
     *
     * @param city The name of the city for which weather data is requested.
     * @return The WeatherData object containing the weather information.
     */
    @GetMapping("/weather/{city}")
    @ResponseBody
    public WeatherData getWeatherData(@PathVariable("city") String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);

        return weatherData;
    }

}
