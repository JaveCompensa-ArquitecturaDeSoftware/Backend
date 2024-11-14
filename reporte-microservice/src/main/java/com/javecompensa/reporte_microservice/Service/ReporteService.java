package com.javecompensa.reporte_microservice.Service;

import com.javecompensa.reporte_microservice.Client.ActividadClient;
import com.javecompensa.reporte_microservice.Client.EventoClient;
import com.javecompensa.reporte_microservice.Client.SedeClient;
import com.javecompensa.reporte_microservice.Model.Actividad;
import com.javecompensa.reporte_microservice.Model.Evento;
import com.javecompensa.reporte_microservice.Model.Reporte;
import com.javecompensa.reporte_microservice.Model.Sede;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private SedeClient sedeClient;

    @Autowired
    private EventoClient eventoClient;

    @Autowired
    private ActividadClient actividadClient;

    public byte[] generarReporte(Long sedeId) throws IOException {
        Sede sede = sedeClient.getSede(sedeId);
        List<Evento> eventos = eventoClient.getEventosBySedeId(sedeId);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Reporte");

        int rowNum = 0;
        Row row = sheet.createRow(rowNum++);
        Cell cell = row.createCell(0);
        cell.setCellValue("Sede: " + sede.getNombre());

        for (Evento evento : eventos) {
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellValue("Evento: " + evento.getNombre());

            List<Actividad> actividades = actividadClient.getActividadesByEventoId(evento.getId());
            for (Actividad actividad : actividades) {
                row = sheet.createRow(rowNum++);
                cell = row.createCell(1);
                cell.setCellValue("Actividad: " + actividad.getNombre());
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
}