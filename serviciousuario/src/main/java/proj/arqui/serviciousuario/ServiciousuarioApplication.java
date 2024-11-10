package proj.arqui.serviciousuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiciousuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciousuarioApplication.class, args);
	}

}
