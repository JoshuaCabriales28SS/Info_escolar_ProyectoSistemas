package mx.uam.service.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmpresaService {
    private final WebClient webClient;

    public EmpresaService(@Qualifier("empresasClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public String obtenerEmpresas() {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                    .path("/forbes400")
                    .queryParam("limit", "10")
                    .build())
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}
