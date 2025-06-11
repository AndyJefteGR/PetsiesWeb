package ucr.ac.cr.Petsies.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.Petsies.Model.User;
import ucr.ac.cr.Petsies.Service.UserService;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);

    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable Integer id){

        return this.userService.findUser(id);
    }
    @GetMapping
    public ArrayList<User> getUsers(){

        return this.userService.getUsers();
    }

    @DeleteMapping("/{id}")
    public User deleteUser( @PathVariable Integer id){

        return this.userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public User editUser( @PathVariable Integer id, @RequestBody User user){

        return this.userService.editUser(id, user);

    }

}
