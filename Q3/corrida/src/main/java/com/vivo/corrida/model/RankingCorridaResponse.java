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
    private String tempoTotalSuperHeroi;
    private Integer melhorVoltaSuperHeroi;
    private Double velocidadeMediaSuperHeroi;
}
