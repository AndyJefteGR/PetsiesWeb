package ucr.ac.cr.Petsies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Petsies.Model.User;
import ucr.ac.cr.Petsies.Repository.IUserRegister;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRegister userRegister;

    public User addUser(User user){
        if (userRegister.existByEmail(user.getEmail())){
            return null;
        }

        userRegister.save(user);
        return null;

    }

    public boolean login(String email, String password){
        Optional<User> optionalUser = userRegister.findByEmail(email);
        return optionalUser.isPresent() && optionalUser.get().getPassword().equals(password);
    }

}
