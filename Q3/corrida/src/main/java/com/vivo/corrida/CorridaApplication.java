package com.vivo.corrida;

import com.vivo.corrida.service.impl.LoadServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CorridaApplication {

	@Autowired
	private LoadServiceImpl loadService;
	public static void main(String[] args) {
		SpringApplication.run(CorridaApplication.class, args);
	}
	@PostConstruct
	public void postContruct() {
		loadService.loadCSVToTable();
	}
}
