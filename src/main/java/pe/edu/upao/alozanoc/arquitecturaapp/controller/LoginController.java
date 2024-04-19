package pe.edu.upao.alozanoc.arquitecturaapp.controller;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upao.alozanoc.arquitecturaapp.model.User;
import pe.edu.upao.alozanoc.arquitecturaapp.respositories.UserRepository;
import pe.edu.upao.alozanoc.arquitecturaapp.serializers.LoginRequest;
import pe.edu.upao.alozanoc.arquitecturaapp.serializers.LoginResponse;
import pe.edu.upao.alozanoc.arquitecturaapp.services.AuthenticationService;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired AuthenticationService authenticationService;

    @PostMapping("/api/v1/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        if(authenticationService.login(request.getUsername(), request.getPassword())) {
            return new LoginResponse("Token");
        } else {
            throw new IllegalArgumentException("Usuario o contraseña incorrecto");
        }
    }
}
