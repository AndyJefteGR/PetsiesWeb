package ucr.ac.cr.Petsies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Petsies.Model.User;
import ucr.ac.cr.Petsies.Repository.UserRepository;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        return this.userRepository.add(user);

    }

    public User findUser(Integer id){

        return this.userRepository.findUser(id);

    }

    public ArrayList<User> getUsers(){

        return this.userRepository.getAllUsers();

    }

    public User deleteById(Integer id){

        return this.userRepository.deleteByID(id);
    }


    public User editUser(Integer id, User user){

        return this.userRepository.editUser(id, user);
    }

}
