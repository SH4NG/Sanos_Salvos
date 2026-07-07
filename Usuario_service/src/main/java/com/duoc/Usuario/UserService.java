package com.duoc.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.Usuario.dto.UserRequestDTO;
import com.duoc.Usuario.dto.UserResponseDTO;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SQSService sqsService;

    public UserResponseDTO register(UserRequestDTO dto) {

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        User saved = userRepository.save(user);
        String mensaje = String.format(
        "Nuevo usuario registrado -> Username: %s, Email: %s",
        saved.getUsername(),
        saved.getEmail()
        );

        sqsService.enviarMensaje(mensaje);
        UserResponseDTO response = new UserResponseDTO();
        response.setId(saved.getId());
        response.setUsername(saved.getUsername());
        response.setEmail(saved.getEmail());
        response.setRole(saved.getRole());

        return response;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}