package com.vivo.corrida.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelatorioCorridaResponse {
    List<RankingCorridaResponse> rankingCorridaResponseList;
    private String tempoTotalProva;
    private Integer melhorVoltaCorrida;
}
