package com.duoc.Reporte.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ReporteRequestDTO {

    @NotNull(message = "El id del usuario es obligatorio")
    @Min(value = 0, message = "No puede ser negativo")
    private Long userId;

    @NotNull(message = "El id de la mascota es obligatorio")
    @Min(value = 0, message = "No puede ser negativo")
    private Long mascotaId;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 40)
    private String nombreReportador;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(max = 13)
    private String telefono;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 100)
    private String descripcion;

    @NotBlank(message = "La ubicación es obligatoria")
    @Size(max = 60)
    private String ubicacion;

    @NotBlank(message = "La imagen es obligatoria")
    private String imagenUrl;

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

    public String getNombreReportador() {
        return nombreReportador;
    }

    public void setNombreReportador(String nombreReportador) {
        this.nombreReportador = nombreReportador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}