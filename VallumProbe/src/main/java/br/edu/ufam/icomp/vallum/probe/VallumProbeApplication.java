package br.edu.ufam.icomp.vallum.probe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="br.edu.ufam.icomp.vallum")
public class VallumProbeApplication {

	public static void main(String[] args) {
		SpringApplication.run(VallumProbeApplication.class, args);
	}

}
