package com.javecompensa.reporte_microservice.Model;

public class Reporte {
    private Sede sede;
    private Evento evento;
    private Actividad actividad;

    // Getters y Setters
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}