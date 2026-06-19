package com.duoc.Reporte;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El id del usuario es obligatoria")
    @Min(value = 0, message = "no puede ser negativo")
    private Long userId;

    @NotNull(message = "El id de la mascota es obligatoria")
    @Min(value = 0, message = "no puede ser negativo")
    private Long mascotaId;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 40)
    private String nombreReportador;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(max = 13)
    private String telefono;

    @NotBlank(message = "Descripcion Obligatoria")
    @Size(max = 100)
    private String descripcion;

    @NotBlank(message = "Ubicacion obligatorio")
    @Size(max = 60)
    private String ubicacion;

    @NotBlank(message = "Link obligatorio")
    private String imagenUrl;

    private String estado;

    public Reporte() {}

    public Long getId() { return id; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getNombreReportador() {
        return nombreReportador;
    }

    public void setNombreReportador(String nombreReportador) {
        this.nombreReportador = nombreReportador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

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
}