package com.vivo.corrida.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultadoCorridaResponse {
    private String codigoSuperHeroi;
    private String nomeHeroi;
    private Long numeroVolta;
    private Long tempoVolta;
    private Double velocidadeVolta;
}
