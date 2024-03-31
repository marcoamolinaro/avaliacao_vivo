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

    @JsonFormat(pattern = "HH:mm:ss.SSS")
    private Date hora;
    private String nomeHeroi;
    private Integer numeroVolta;
    @JsonFormat(pattern = "HH:mm:ss.SSS")
    private Date tempoVolta;
    private Double velocidadeVolta;
}
