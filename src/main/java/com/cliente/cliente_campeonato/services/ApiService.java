package com.cliente.cliente_campeonato.services;

import com.cliente.cliente_campeonato.models.CampeonatoDTO;
import com.cliente.cliente_campeonato.models.EquipoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ApiService {
    
    @Value("${api.base.url}")
    private String apiBaseUrl;
    
    private final WebClient webClient;
    
    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }
    
    // Obtener todos los equipos
    public List<EquipoDTO> listarEquipos() {
        return webClient.get()
                .uri("/api/equipos/listar")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EquipoDTO>>() {})
                .block();
    }
    
    // Buscar por nombre
    public List<EquipoDTO> buscarPorNombre(String nombre) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/equipos/buscarPorNombre")
                        .queryParam("nombre", nombre)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EquipoDTO>>() {})
                .block();
    }
    
    // Buscar por ciudad
    public List<EquipoDTO> buscarPorCiudad(String ciudad) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/equipos/buscarPorCiudad")
                        .queryParam("ciudad", ciudad)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EquipoDTO>>() {})
                .block();
    }
    
    // Buscar por campeonato
    public List<EquipoDTO> buscarPorCampeonato(Long idCampeonato) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/equipos/buscarPorCampeonato")
                        .queryParam("idCampeonato", idCampeonato)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<EquipoDTO>>() {})
                .block();
    }
    
    // Obtener lista de ciudades (para el select)
    public List<String> listarCiudades() {
        return webClient.get()
                .uri("/api/equipos/ciudades")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {})
                .block();
    }
    
    // Obtener lista de campeonatos (para el select)
    public List<CampeonatoDTO> listarCampeonatos() {
        return webClient.get()
                .uri("/api/equipos/campeonatos")
                .retrieve()
                .bodyToFlux(CampeonatoDTO.class)
                .collectList()
                .block();
    }
}