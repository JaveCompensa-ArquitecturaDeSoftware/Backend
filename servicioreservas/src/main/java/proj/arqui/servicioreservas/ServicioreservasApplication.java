package proj.arqui.servicioreservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicioreservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioreservasApplication.class, args);
	}

}
