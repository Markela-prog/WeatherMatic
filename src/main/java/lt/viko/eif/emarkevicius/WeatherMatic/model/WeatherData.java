package lt.viko.eif.emarkevicius.WeatherMatic.model;

/**
 * The WeatherData class represents the weather data for a specific location.
 * It contains information about the main weather parameters, location name, weather conditions, and system data.
 */
public class WeatherData {
    private MainData main;
    private String name;
    private Weather[] weather;
    private SysData sys;

    /**
     * Retrieves the main weather data.
     *
     * @return The MainData object representing the main weather parameters.
     */
    public MainData getMain() {
        return main;
    }

    /**
     * Sets the main weather data.
     *
     * @param main The MainData object representing the main weather parameters.
     */
    public void setMain(MainData main) {
        this.main = main;
    }

    /**
     * Retrieves the name of the location for which weather data is provided.
     *
     * @return The name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the location for which weather data is provided.
     *
     * @param name The name of the location.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the weather conditions for the location.
     *
     * @return An array of Weather objects representing the weather conditions.
     */
    public Weather[] getWeather() {
        return weather;
    }

    /**
     * Sets the weather conditions for the location.
     *
     * @param weather An array of Weather objects representing the weather conditions.
     */
    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    /**
     * Retrieves the system data for the location.
     *
     * @return The SysData object representing the system data.
     */
    public SysData getSys() {
        return sys;
    }

    /**
     * Sets the system data for the location.
     *
     * @param sys The SysData object representing the system data.
     */
    public void setSys(SysData sys) {
        this.sys = sys;
    }

    /**
     * The MainData class represents the main weather parameters.
     */
    public static class MainData {
        private double temp;

        /**
         * Retrieves the temperature.
         *
         * @return The temperature value.
         */
        public double getTemp() {
            return temp;
        }

        /**
         * Sets the temperature.
         *
         * @param temp The temperature value.
         */
        public void setTemp(double temp) {
            this.temp = temp;
        }
    }

    /**
     * The Weather class represents the weather conditions.
     */
    public static class Weather {
        private String description;
        private String icon;

        /**
         * Retrieves the weather description.
         *
         * @return The weather description.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the weather description.
         *
         * @param description The weather description.
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * Retrieves the weather icon.
         *
         * @return The weather icon.
         */
        public String getIcon() {
            return icon;
        }

        /**
         * Sets the weather icon.
         *
         * @param icon The weather icon.
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    /**
     * The SysData class represents the system data.
     */
    public static class SysData {
        private long sunrise;
        private long sunset;

        /**
         * Retrieves the sunrise time.
         *
         * @return The sunrise time in milliseconds since the epoch.
         */
        public long getSunrise() {
            return sunrise;
        }

        /**
         * Sets the sunrise time.
         *
         * @param sunrise The sunrise time in milliseconds since the epoch.
         */
        public void setSunrise(long sunrise) {
            this.sunrise = sunrise;
        }

        /**
         * Retrieves the sunset time.
         *
         * @return The sunset time in milliseconds since the epoch.
         */
        public long getSunset() {
            return sunset;
        }

        /**
         * Sets the sunset time.
         *
         * @param sunset The sunset time in milliseconds since the epoch.
         */
        public void setSunset(long sunset) {
            this.sunset = sunset;
        }
    }
}



