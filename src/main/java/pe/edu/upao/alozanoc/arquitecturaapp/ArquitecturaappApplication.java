package pe.edu.upao.alozanoc.arquitecturaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.upao.alozanoc.arquitecturaapp.respositories.UserRepository;
import pe.edu.upao.alozanoc.arquitecturaapp.services.AuthenticationService;

import java.util.HashMap;

@SpringBootApplication
public class ArquitecturaappApplication {

    public static void main(String[] args) {
        new AuthenticationService();
        SpringApplication.run(ArquitecturaappApplication.class, args);
    }

}
