package ucr.ac.cr.Petsies.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.Petsies.Model.User;

import java.util.Optional;

@Repository
public interface IUserRegister extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    boolean existByEmail(String email);
}
