package Etanat.Etanat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Etanat.Etanat.domain.Etana;
import Etanat.Etanat.domain.EtanaRepository;

@SpringBootApplication
public class EtanatApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtanatApplication.class, args);
	}
	


}
