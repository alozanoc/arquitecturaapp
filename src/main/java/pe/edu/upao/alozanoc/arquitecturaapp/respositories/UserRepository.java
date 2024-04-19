package pe.edu.upao.alozanoc.arquitecturaapp.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upao.alozanoc.arquitecturaapp.model.User;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u where u.username = :username")
    Optional<User> findByUsername(String username);
}
