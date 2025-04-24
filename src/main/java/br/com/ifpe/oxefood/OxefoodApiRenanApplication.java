package br.com.ifpe.oxefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //Preencher os dados de auditoria
public class OxefoodApiRenanApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxefoodApiRenanApplication.class, args);
	}
}
