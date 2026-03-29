package mx.uam.service.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UniversidadService {
    private final WebClient webClient;

    public UniversidadService(@Qualifier("universidadesClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public String obtenerDatos() {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                    .path("/search")
                    .queryParam("country", "Mexico")
                    .build())
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}
