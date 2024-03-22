package lt.viko.eif.emarkevicius.WeatherMatic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *  The CorsConfig class provides configuration for Cross-Origin Resource Sharing (CORS).
 *  It allows requests from any origin, method, and header.
 */
@Configuration
public class CorsConfig {

    /**
     * Creates and configures a CorsFilter bean to handle CORS requests.
     * @return The CorsFilter bean.
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Allow requests from any origin
        config.addAllowedMethod("*"); // Allow all HTTP methods
        config.addAllowedHeader("*"); // Allow all headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
