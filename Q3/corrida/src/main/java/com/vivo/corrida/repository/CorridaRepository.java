package com.vivo.corrida.repository;

import com.vivo.corrida.entity.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {
}
