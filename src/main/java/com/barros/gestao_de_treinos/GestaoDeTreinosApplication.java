package com.barros.gestao_de_treinos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.barros.gestao_de_treinos.repositories.neo4j")
@EntityScan(basePackages = "com.barros.gestao_de_treinos.entities.neo4j")
public class GestaoDeTreinosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeTreinosApplication.class, args);
	}

}
