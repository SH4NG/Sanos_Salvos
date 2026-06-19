package com.duoc.Mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.duoc.Mascota.dto.MascotaRequestDTO;
import com.duoc.Mascota.dto.MascotaResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    // GET ALL
    @GetMapping
    public Iterable<MascotaResponseDTO> getAllMascotas() {
        return mascotaService.getAllMascotas();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public MascotaResponseDTO getMascotaById(@PathVariable Long id) {
        return mascotaService.getMascotaById(id);
    }

    // CREAR
    @PostMapping
    public MascotaResponseDTO crear(@Valid @RequestBody MascotaRequestDTO mascotaDTO) {
        return mascotaService.saveMascota(mascotaDTO);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void deleteMascota(@PathVariable Long id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (!isAdmin) {
            throw new RuntimeException("Solo ADMIN puede eliminar mascotas");
        }

        mascotaService.deleteMascota(id);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public MascotaResponseDTO updateMascota(
            @PathVariable Long id,
            @Valid @RequestBody MascotaRequestDTO mascotaDTO) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (!isAdmin) {
            throw new RuntimeException("Solo ADMIN puede editar mascotas");
        }

        return mascotaService.updateMascota(id, mascotaDTO);
    }
}