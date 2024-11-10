package proj.arqui.serviciosedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiciosedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciosedesApplication.class, args);
	}

}
