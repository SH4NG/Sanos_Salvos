package com.duoc.Reporte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.Reporte.dto.ReporteRequestDTO;
import com.duoc.Reporte.dto.ReporteResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // CREAR REPORTE
    @PostMapping
    public ReporteResponseDTO crearReporte(@Valid @RequestBody ReporteRequestDTO dto) {
        return reporteService.guardarReporte(dto);
    }

    // VER SOLO ENCONTRADAS
    @GetMapping("/encontradas")
    public List<ReporteResponseDTO> getEncontradas() {
        return reporteService.obtenerReportesEncontrados();
    }

    // VER TODOS
    @GetMapping
    public List<ReporteResponseDTO> getAllReportes() {
        return reporteService.getAllReportes();
    }

    // SOLO ADMIN BORRA
    @DeleteMapping("/{id}")
    public void deleteReporte(@PathVariable Long id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (!isAdmin) {
            throw new RuntimeException("Solo ADMIN puede eliminar reportes");
        }

        reporteService.deleteReporte(id);
    }
}