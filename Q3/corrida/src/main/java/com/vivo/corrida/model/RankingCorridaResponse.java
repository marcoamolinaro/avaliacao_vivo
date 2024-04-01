package com.vivo.corrida.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RankingCorridaResponse {
    private Integer posicaoChegada;
    private String codigoSuperHeroi;
    private String nomeSuperHeroi;
    private Long quantidadeVoltasCompletas;
    private Long tempoTotalSuperHeroi;
    private Long melhorVoltaSuperHeroi;
    private Double velocidadeMediaSuperHeroi;
}
