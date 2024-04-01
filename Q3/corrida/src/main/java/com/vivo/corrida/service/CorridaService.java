package com.vivo.corrida.service;

import com.vivo.corrida.dto.CorridaDTO;
import com.vivo.corrida.entity.Corrida;
import com.vivo.corrida.model.ResultadoCorridaResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CorridaService {
    List<ResultadoCorridaResponse> lerResultadoCorrida();
    Corrida lerMelhorVolta(String codigoSuperHeroi);
}
