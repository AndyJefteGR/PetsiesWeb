package ucr.ac.cr.Petsies.Repository;

import org.springframework.stereotype.Repository;
import ucr.ac.cr.Petsies.Model.User;

import java.util.ArrayList;

@Repository
public class UserRepository {

    private ArrayList<User> userList;

    public UserRepository(ArrayList<User> listUser) {

        this.userList = new ArrayList<>();

    }

    public User add(User user){

        this.userList.add(user);
        return user;

    }

    public User findUser(Integer id){

        for (User user : userList) {
            
            if (user.getId() == id) {

                return user;

            }
        }
        
        return new User();

    }

    public ArrayList<User> getAllUsers(){
        return this.userList;
    }

    public User deleteByID(Integer id){
        
        User user = this.findUser(id);
        
        if (user.getId()==null){

            return new User();
            
        }
        
        this.userList.remove(user);
        return user;
        
    }

    public User editUser(Integer id, User userEdit){


        for (int i = 0; i < userList.size(); i++) {
            
            if (userList.get(i).getId() == id) {

                userList.set(i, userEdit);
                return userEdit;

            }
        }
        
        return new User();
        
    }
}
