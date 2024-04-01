package com.vivo.corrida.service.impl;

import com.vivo.corrida.dto.CorridaDTO;
import com.vivo.corrida.entity.Corrida;
import com.vivo.corrida.model.ResultadoCorridaResponse;
import com.vivo.corrida.repository.CorridaRepository;
import com.vivo.corrida.service.CorridaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorridaServiceImpl implements CorridaService {

    @Autowired
    private CorridaRepository corridaRepository;

    @Override
    public List<ResultadoCorridaResponse> lerResultadoCorrida() {
        return corridaRepository.lerResultadoCorrida();
    }

    @Override
    public Corrida lerMelhorVolta(String codigoSuperHeroi) {
        List<Corrida> corridaDTOList =
                corridaRepository.findByCodigoSuperHeroiOrderByVelocidadeVoltaAsc(codigoSuperHeroi);
        Corrida corrida = corridaDTOList.get(0);
        return corrida;
    }
}
