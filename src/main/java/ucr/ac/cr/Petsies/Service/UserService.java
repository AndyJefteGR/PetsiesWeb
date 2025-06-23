package ucr.ac.cr.Petsies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Petsies.Model.User;
import ucr.ac.cr.Petsies.Repository.IUserRegister;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    IUserRegister userRegister;

    public User addUser(User user){
        return this.userRegister.addUser(user);

    }

    public User findUser(Integer id){

        return this.userRegister.findUser(id);

    }

    public ArrayList<User> getUsers(){

        return this.userRegister.getUsers();

    }

    public User deleteById(Integer id){

        return this.userRegister.deleteById(id);
    }


    public User editUser(Integer id, User user){

        return this.userRegister.editUser(id, user);
    }

    public Boolean existID(Integer id){

        return this.userRegister.existID(id);

    }

}
