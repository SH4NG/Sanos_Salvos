package com.duoc.Mascota;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.Mascota.dto.MascotaRequestDTO;
import com.duoc.Mascota.dto.MascotaResponseDTO;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    // GET ALL
    public List<MascotaResponseDTO> getAllMascotas() {

        List<MascotaResponseDTO> lista = new ArrayList<>();

        mascotaRepository.findAll().forEach(m -> {
            MascotaResponseDTO dto = convertirADTO(m);
            lista.add(dto);
        });

        return lista;
    }

    // GET BY ID
    public MascotaResponseDTO getMascotaById(Long id) {

        Mascota mascota = mascotaRepository.findById(id).orElse(null);

        if (mascota == null) {
            return null;
        }

        return convertirADTO(mascota);
    }

    // CREAR
    public MascotaResponseDTO saveMascota(MascotaRequestDTO dto) {

        Mascota mascota = new Mascota();

        mascota.setNombre(dto.getNombre());
        mascota.setTipo(dto.getTipo());
        mascota.setRaza(dto.getRaza());
        mascota.setColor(dto.getColor());
        mascota.setEdad(dto.getEdad());

        mascota = mascotaRepository.save(mascota);

        return convertirADTO(mascota);
    }

    // ELIMINAR
    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    // ACTUALIZAR
    public MascotaResponseDTO updateMascota(Long id, MascotaRequestDTO dto) {

        Mascota mascota = mascotaRepository.findById(id).orElse(null);

        if (mascota == null) {
            return null;
        }

        mascota.setNombre(dto.getNombre());
        mascota.setTipo(dto.getTipo());
        mascota.setRaza(dto.getRaza());
        mascota.setColor(dto.getColor());
        mascota.setEdad(dto.getEdad());

        mascota = mascotaRepository.save(mascota);

        return convertirADTO(mascota);
    }

    // CONVERTIR ENTIDAD -> DTO
    private MascotaResponseDTO convertirADTO(Mascota mascota) {

        MascotaResponseDTO dto = new MascotaResponseDTO();

        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setTipo(mascota.getTipo());
        dto.setRaza(mascota.getRaza());
        dto.setColor(mascota.getColor());
        dto.setEdad(mascota.getEdad());

        return dto;
    }
}