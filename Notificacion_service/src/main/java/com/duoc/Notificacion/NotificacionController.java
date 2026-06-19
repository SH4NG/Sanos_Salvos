package com.duoc.Notificacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.Notificacion.dto.NotificacionRequestDTO;
import com.duoc.Notificacion.dto.NotificacionResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    // CREAR NOTIFICACIÓN
    @PostMapping
    public NotificacionResponseDTO crear(
            @Valid @RequestBody NotificacionRequestDTO dto) {

        return service.crear(dto);
    }

    // VER NOTIFICACIONES DE UN USUARIO
    @GetMapping("/usuario/{userId}")
    public List<NotificacionResponseDTO> obtenerPorUsuario(
            @PathVariable Long userId) {

        return service.obtenerPorUsuario(userId);
    }

    // MARCAR COMO LEÍDA
    @PutMapping("/{id}/leer")
    public void marcarLeida(@PathVariable Long id) {

        service.marcarLeida(id);
    }
}