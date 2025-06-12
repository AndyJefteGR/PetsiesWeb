package ucr.ac.cr.Petsies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Petsies.Model.User;
import ucr.ac.cr.Petsies.Repository.IUserRegister;
import ucr.ac.cr.Petsies.Repository.UserRepository;

import java.util.ArrayList;

@Service
public class UserService implements IUserRegister {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        return this.userRepository.addUser(user);

    }

    public User findUser(Integer id){

        return this.userRepository.findUser(id);

    }

    public ArrayList<User> getUsers(){

        return this.userRepository.getUsers();

    }

    public User deleteById(Integer id){

        return this.userRepository.deleteById(id);
    }


    public User editUser(Integer id, User user){

        return this.userRepository.editUser(id, user);
    }

    public Boolean existID(Integer id){

        return this.userRepository.existID(id);

    }

}
