package com.vivo.corrida.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String hora;
    private String codigoSuperHeroi;
    private String nomeHeroi;
    private Integer numeroVolta;
    private Long tempoVolta;
    private Double velocidadeVolta;
}
