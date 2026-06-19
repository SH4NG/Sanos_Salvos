package com.duoc.Reporte;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.Reporte.dto.ReporteRequestDTO;
import com.duoc.Reporte.dto.ReporteResponseDTO;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    // Crear reporte
    public ReporteResponseDTO guardarReporte(ReporteRequestDTO dto) {

        Reporte reporte = new Reporte();

        reporte.setUserId(dto.getUserId());
        reporte.setMascotaId(dto.getMascotaId());
        reporte.setNombreReportador(dto.getNombreReportador());
        reporte.setTelefono(dto.getTelefono());
        reporte.setDescripcion(dto.getDescripcion());
        reporte.setUbicacion(dto.getUbicacion());
        reporte.setImagenUrl(dto.getImagenUrl());

        // Estado por defecto
        reporte.setEstado("ENCONTRADO");

        Reporte guardado = reporteRepository.save(reporte);

        return convertirDTO(guardado);
    }

    // Obtener encontrados
    public List<ReporteResponseDTO> obtenerReportesEncontrados() {
        return reporteRepository.findByEstado("ENCONTRADO")
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // Obtener todos
    public List<ReporteResponseDTO> getAllReportes() {
        return reporteRepository.findAll()
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // Eliminar
    public void deleteReporte(Long id) {
        if (reporteRepository.existsById(id)) {
            reporteRepository.deleteById(id);
        }
    }

    // Conversión Entity -> DTO
    private ReporteResponseDTO convertirDTO(Reporte reporte) {

        ReporteResponseDTO dto = new ReporteResponseDTO();

        dto.setId(reporte.getId());
        dto.setUserId(reporte.getUserId());
        dto.setMascotaId(reporte.getMascotaId());
        dto.setNombreReportador(reporte.getNombreReportador());
        dto.setTelefono(reporte.getTelefono());
        dto.setDescripcion(reporte.getDescripcion());
        dto.setUbicacion(reporte.getUbicacion());
        dto.setImagenUrl(reporte.getImagenUrl());
        dto.setEstado(reporte.getEstado());

        return dto;
    }
}