package com.duoc.Mascota.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MascotaRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 30)
    private String nombre;

    @NotBlank(message = "El tipo es obligatorio")
    @Size(max = 30)
    private String tipo;

    @NotBlank(message = "La raza es obligatoria")
    @Size(max = 30)
    private String raza;

    @NotBlank(message = "El color es obligatorio")
    @Size(max = 15)
    private String color;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer edad;

    public MascotaRequestDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}