package mx.uam.service.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CarrerasService {
    private final WebClient webClient;

    public CarrerasService(@Qualifier("carrerasClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public String obtenerCarreras() {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                    .path("/search")
                    .queryParam("type", "occupation")
                    .queryParam("text", "developer")
                    .build())
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}
