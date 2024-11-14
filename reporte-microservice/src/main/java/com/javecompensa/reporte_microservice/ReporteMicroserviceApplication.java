package com.javecompensa.reporte_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReporteMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReporteMicroserviceApplication.class, args);
    }
}
