package com.duoc.Notificacion;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.Notificacion.dto.NotificacionRequestDTO;
import com.duoc.Notificacion.dto.NotificacionResponseDTO;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository repo;

    // CREAR NOTIFICACIÓN
    public NotificacionResponseDTO crear(NotificacionRequestDTO dto) {

        Notificacion n = new Notificacion();

        n.setUserId(dto.getUserId());
        n.setMascotaId(dto.getMascotaId());
        n.setReporteId(dto.getReporteId());

        // Se generan automáticamente
        n.setMensaje("Se encontró una mascota que coincide con tu reporte.");
        n.setFecha(LocalDate.now().toString());
        n.setLeida(false);

        Notificacion guardada = repo.save(n);

        return convertirDTO(guardada);
    }

    // OBTENER NOTIFICACIONES DE UN USUARIO
    public List<NotificacionResponseDTO> obtenerPorUsuario(Long userId) {

        return repo.findByUserId(userId)
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    // MARCAR COMO LEÍDA
    public void marcarLeida(Long id) {

        Notificacion n = repo.findById(id).orElseThrow();

        n.setLeida(true);

        repo.save(n);
    }

    // CONVERTIR ENTITY -> RESPONSE DTO
    private NotificacionResponseDTO convertirDTO(Notificacion n) {

        NotificacionResponseDTO dto = new NotificacionResponseDTO();

        dto.setId(n.getId());
        dto.setUserId(n.getUserId());
        dto.setMascotaId(n.getMascotaId());
        dto.setReporteId(n.getReporteId());
        dto.setMensaje(n.getMensaje());
        dto.setLeida(n.isLeida());
        dto.setFecha(n.getFecha());

        return dto;
    }
}