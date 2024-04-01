package com.vivo.corrida.repository;

import com.vivo.corrida.dto.CorridaDTO;
import com.vivo.corrida.model.ResultadoCorridaResponse;
import com.vivo.corrida.entity.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {

    @Transactional(readOnly=true)
    @Query(value = "SELECT new com.vivo.corrida.model.ResultadoCorridaResponse(codigoSuperHeroi, nomeHeroi, count(numeroVolta) as volta, sum(tempoVolta) as tempo, avg(velocidadeVolta) as media) FROM Corrida GROUP BY codigoSuperHeroi, nomeHeroi ORDER BY volta DESC, tempo ASC ")
    List<ResultadoCorridaResponse> lerResultadoCorrida();
    List<Corrida> findByCodigoSuperHeroiOrderByVelocidadeVoltaAsc(String codigoSuperHeroi);
}
