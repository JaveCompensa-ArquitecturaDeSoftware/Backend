package proj.arqui.servicioeventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicioeventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioeventosApplication.class, args);
	}

}
