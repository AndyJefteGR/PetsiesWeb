package ucr.ac.cr.Petsies.Repository;

import org.springframework.stereotype.Repository;
import ucr.ac.cr.Petsies.Model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRegister {

    private ArrayList<User> userList;

    public UserRepository(ArrayList<User> listUser) {

        this.userList = new ArrayList<>();

    }

    public User addUser(User user){

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

    public ArrayList<User> getUsers(){
        return this.userList;
    }

    public User deleteById(Integer id){
        
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

    public Boolean existID(Integer id) {
        for (int i = 0; i < this.userList.size(); ++i) {
            if (((User) this.userList.get(i)).getId() == id) {
                return true;
            }
        }

        return false;

    }

}
