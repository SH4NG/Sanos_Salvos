package com.duoc.Notificacion.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class NotificacionRequestDTO {

    @NotNull(message = "El id del usuario es obligatorio")
    @Min(value = 1)
    private Long userId;

    @NotNull(message = "El id de la mascota es obligatorio")
    @Min(value = 1)
    private Long mascotaId;

    @NotNull(message = "El id del reporte es obligatorio")
    @Min(value = 1)
    private Long reporteId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(Long mascotaId) {
        this.mascotaId = mascotaId;
    }

    public Long getReporteId() {
        return reporteId;
    }

    public void setReporteId(Long reporteId) {
        this.reporteId = reporteId;
    }
}