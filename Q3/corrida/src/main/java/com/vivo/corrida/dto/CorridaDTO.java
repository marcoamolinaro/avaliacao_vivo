package com.vivo.corrida.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorridaDTO {

    private Long id;
    private String hora;
    private String codigoSuperHeroi;
    private String nomeHeroi;
    private Integer numeroVolta;
    private long tempoVolta;
    private Double velocidadeVolta;
}
