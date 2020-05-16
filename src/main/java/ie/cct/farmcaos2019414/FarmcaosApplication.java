package ie.cct.farmcaos2019414;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ie.cct.*")
public class FarmcaosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmcaosApplication.class, args);
	}

}
