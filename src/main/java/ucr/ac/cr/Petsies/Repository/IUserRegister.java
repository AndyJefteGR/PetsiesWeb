package ucr.ac.cr.Petsies.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.cr.Petsies.Model.User;





public interface IUserRegister extends JpaRepository<User, Integer> {

}
