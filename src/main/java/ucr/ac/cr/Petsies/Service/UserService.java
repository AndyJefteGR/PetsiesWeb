package ucr.ac.cr.Petsies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Petsies.Model.Pet;
import ucr.ac.cr.Petsies.Model.User;
import ucr.ac.cr.Petsies.Repository.IUserRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRegister userRegister;

    public User addUser(User user){
        if (userRegister.existsByEmail(user.getEmail())){
            return null;
        }

        userRegister.save(user);
        return null;

    }

    public boolean login(String email, String password){
        Optional<User> optionalUser = userRegister.findByEmail(email);
        return optionalUser.isPresent() && optionalUser.get().getPassword().equals(password);
    }

    public List<User> getAllUsers() {
        return userRegister.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRegister.findById(id);
    }

    public void deleteUserById(Integer id) {
        userRegister.deleteById(id);
    }

    public User editUser(Integer id, User user){
        Optional<User> userOptional = this.userRegister.findById(id);
        if (userOptional.isEmpty()) {
            return new User();
        }

        User previousUser = userOptional.get();

        previousUser.setName(user.getName());
        previousUser.setName(user.getPassword());
        previousUser.setEmail(user.getEmail());
        previousUser.setNum_tel(user.getNum_tel());


        return this.userRegister.save(previousUser);

    }

}
