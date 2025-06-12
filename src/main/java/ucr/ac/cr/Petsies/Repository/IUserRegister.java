package ucr.ac.cr.Petsies.Repository;

import ucr.ac.cr.Petsies.Model.User;

import java.util.ArrayList;




public interface IUserRegister {

    User addUser(User user);

    User findUser(Integer id);

    ArrayList<User> getUsers();

    User deleteById(Integer id);

    User editUser(Integer id, User editUser);



}
