package com.javecompensa.reporte_microservice.Client;

import com.javecompensa.reporte_microservice.Model.Sede;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sede-service")
public interface SedeClient {
    @GetMapping("/Sede/{id}")
    Sede getSede(@PathVariable("id") Long id);
}
