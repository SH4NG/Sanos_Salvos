package com.duoc.Notificacion;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "El id del usuario es obligatoria")
    @Min(value = 0, message = "no puede ser negativo")
    private Long userId;      // Usuario que recibirá la notificación

    @NotNull(message = "El id de la mascota es obligatoria")
    @Min(value = 0, message = "no puede ser negativo")
    private Long mascotaId;   // Mascota relacionada

    @NotNull(message = "El id del reporte es obligatoria")
    @Min(value = 0, message = "no puede ser negativo")
    private Long reporteId;   // Reporte que originó la notificación

    private String mensaje;
    private boolean leida = false;
    private String fecha;

    public Notificacion() {}

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getMascotaId() { return mascotaId; }
    public Long getReporteId() { return reporteId; }
    public String getMensaje() { return mensaje; }
    public boolean isLeida() { return leida; }
    public String getFecha() { return fecha; }

    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setMascotaId(Long mascotaId) { this.mascotaId = mascotaId; }
    public void setReporteId(Long reporteId) { this.reporteId = reporteId; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public void setLeida(boolean leida) { this.leida = leida; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}