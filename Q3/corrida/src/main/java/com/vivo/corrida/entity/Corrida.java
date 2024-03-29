package com.vivo.corrida.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "corrida")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Corrida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "HH:mm:ss.SSS")
    private Instant hora;
    private String nomeHeroi;
    private Integer numeroVolta;
    @JsonFormat(pattern = "mm:ss.SSS")
    private Instant tempoVolta;
    private Double velocidadeVolta;
}
