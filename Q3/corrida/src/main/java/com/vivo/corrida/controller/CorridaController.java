package com.vivo.corrida.controller;

import com.vivo.corrida.dto.CorridaDTO;
import com.vivo.corrida.entity.Corrida;
import com.vivo.corrida.model.RankingCorridaResponse;
import com.vivo.corrida.model.RelatorioCorridaResponse;
import com.vivo.corrida.model.ResultadoCorridaResponse;
import com.vivo.corrida.service.CorridaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/")
public class CorridaController {

    @Autowired
    private CorridaService corridaService;

    @GetMapping(value = "/teste")
    public String teste() {

        //List<CorridaDTO> corridas = new ArrayList<>();

        //corridas = CSVHelper.csvToOrders();

        return "Hello World!";
    }

    @GetMapping(value = "/corrida")
    public ResponseEntity<RelatorioCorridaResponse> corrida() {

        List<RankingCorridaResponse> rankingCorridaResponseList = new ArrayList<>();

        List<ResultadoCorridaResponse> listResultado = corridaService.lerResultadoCorrida();

        List<RankingCorridaResponse> rankingList = preencherResultado(listResultado, 0);

        rankingCorridaResponseList.addAll(rankingList);

        List<RelatorioCorridaResponse> list = new ArrayList<>();

        RelatorioCorridaResponse relatorioCorridaResponse = new RelatorioCorridaResponse();

        relatorioCorridaResponse = RelatorioCorridaResponse.builder()
                .rankingCorridaResponseList(rankingCorridaResponseList)
                .melhorVoltaCorrida(4)
                .tempoTotalProva("3:45.456")
                .build();

        return new ResponseEntity<>(relatorioCorridaResponse, HttpStatus.OK);
    }

    public List<RankingCorridaResponse> preencherResultado(List<ResultadoCorridaResponse> listPrimeiros, int posicao) {
        int pos = posicao;
        List<RankingCorridaResponse> rankingCorridaResponseList = new ArrayList<>();
        for (ResultadoCorridaResponse rcp : listPrimeiros) {
            pos++;
            Corrida corrida = corridaService.lerMelhorVolta(rcp.getCodigoSuperHeroi());
            RankingCorridaResponse rankingCorridaResponse = RankingCorridaResponse.builder()
                    .posicaoChegada(pos)
                    .codigoSuperHeroi(rcp.getCodigoSuperHeroi())
                    .nomeSuperHeroi(rcp.getNomeHeroi())
                    .quantidadeVoltasCompletas(rcp.getNumeroVolta())
                    .tempoTotalSuperHeroi(rcp.getTempoVolta())
                    .melhorVoltaSuperHeroi(corrida.getNumeroVolta())
                    .velocidadeMediaSuperHeroi(rcp.getVelocidadeVolta())
                    .build();
            rankingCorridaResponseList.add(rankingCorridaResponse);
        }
        return rankingCorridaResponseList;
    }
}
