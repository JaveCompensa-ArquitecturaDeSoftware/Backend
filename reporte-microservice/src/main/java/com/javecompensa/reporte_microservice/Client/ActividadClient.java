package com.javecompensa.reporte_microservice.Client;

import com.javecompensa.reporte_microservice.Model.Actividad;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "actividad-service")
public interface ActividadClient {
    @GetMapping("/Actividad/{id}")
    Actividad getActividad(@PathVariable("id") Long id);

    @GetMapping("/Actividad")
    List<Actividad> getActividadesByEventoId(@RequestParam("eventoId") Long eventoId);
}
