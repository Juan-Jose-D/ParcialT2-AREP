package edu.eci.arep.parcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.eci.arep.parcial.service.MathService;
import java.util.ArrayList;

@SpringBootApplication
public class ParcialApplication {

	public static void main(String[] args) {
		MathService mathService = new MathService();
		//SpringApplication.run(ParcialApplication.class, args);
		ArrayList resultado = mathService.numerosCatalan(10);
		System.out.println(resultado);
	}

}
