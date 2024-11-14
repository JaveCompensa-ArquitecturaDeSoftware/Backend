package com.javecompensa.reporte_microservice.Client;

import com.javecompensa.reporte_microservice.Model.Evento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "evento-service")
public interface EventoClient {
    @GetMapping("/Evento/{id}")
    Evento getEvento(@PathVariable("id") Long id);

    @GetMapping("/Evento")
    List<Evento> getEventosBySedeId(@RequestParam("sedeId") Long sedeId);
}