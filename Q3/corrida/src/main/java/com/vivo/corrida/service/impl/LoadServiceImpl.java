package com.vivo.corrida.service.impl;

import com.vivo.corrida.dto.CorridaDTO;
import com.vivo.corrida.entity.Corrida;
import com.vivo.corrida.helper.CSVHelper;
import com.vivo.corrida.repository.CorridaRepository;
import com.vivo.corrida.service.LoadService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private CorridaRepository corridaRepository;

    @PostConstruct
    public void loadCSVToTable() {
        List<CorridaDTO> corridaDTOList = CSVHelper.csvToOrders();

        for (CorridaDTO dto : corridaDTOList) {
            Corrida corrida = Corrida.builder()
                    .hora(dto.getHora())
                    .nomeHeroi(dto.getNomeHeroi())
                    .numeroVolta(dto.getNumeroVolta())
                    .tempoVolta(dto.getTempoVolta())
                    .velocidadeVolta(dto.getVelocidadeVolta())
                    .build();
            corridaRepository.save(corrida);
        }
    }
}
