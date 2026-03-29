package mx.uam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient universidadesClient() {
        return WebClient.builder()
            .baseUrl("http://universities.hipolabs.com")
            .build();
    }

    @Bean
    public WebClient carrerasClient() {
        return WebClient.builder()
            .baseUrl("https://ec.europa.eu/esco/api")
            .build();
    }

    @Bean
    public WebClient empresasClient() {
        return WebClient.builder()
            .baseUrl("https://forbes400.onrender.com/api")
            .build();
    }
}
