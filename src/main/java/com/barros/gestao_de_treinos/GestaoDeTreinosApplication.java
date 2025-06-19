package com.barros.gestao_de_treinos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "com.barros.gestao_de_treinos.repositories")
@EntityScan(basePackages = "com.barros.gestao_de_treinos.entities")
public class GestaoDeTreinosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeTreinosApplication.class, args);
	}

}
