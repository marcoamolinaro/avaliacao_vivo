package com.vivo.corrida.service.impl;

import com.vivo.corrida.dto.CorridaDTO;
import com.vivo.corrida.entity.Corrida;
import com.vivo.corrida.exception.CustomException;
import com.vivo.corrida.helper.CSVHelper;
import com.vivo.corrida.repository.CorridaRepository;
import com.vivo.corrida.service.LoadService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private CorridaRepository corridaRepository;

    @PostConstruct
    public void loadCSVToTable() throws Exception {
        try {
            List<CorridaDTO> corridaDTOList = CSVHelper.csvToOrders();

            for (CorridaDTO dto : corridaDTOList) {
                Corrida corrida = Corrida.builder()
                        .hora(dto.getHora())
                        .codigoSuperHeroi(dto.getCodigoSuperHeroi())
                        .nomeHeroi(dto.getNomeHeroi())
                        .numeroVolta(dto.getNumeroVolta())
                        .tempoVolta(dto.getTempoVolta())
                        .velocidadeVolta(dto.getVelocidadeVolta())
                        .build();
                corridaRepository.save(corrida);
            }
        } catch (Exception e) {
            throw new CustomException("Erro ao importar arquivo de log de corrida", "RUNTIME_EXCEPTION", 500);
        }
    }
}
