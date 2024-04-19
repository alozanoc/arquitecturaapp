package pe.edu.upao.alozanoc.arquitecturaapp.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upao.alozanoc.arquitecturaapp.model.User;
import pe.edu.upao.alozanoc.arquitecturaapp.respositories.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService {

    public final UserRepository userRepository;

    // NOSONAR
    public boolean login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get().getPassword().equals("123");
        }
        return false;
    }
}
