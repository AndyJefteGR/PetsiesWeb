package ucr.ac.cr.Petsies.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.Petsies.Model.Pet;
import ucr.ac.cr.Petsies.Model.User;
import ucr.ac.cr.Petsies.Service.UserService;

import java.util.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@Validated @RequestBody User user, BindingResult result){
        if (!result.hasErrors()) {
            Optional<User> userOp = this.userService.getUserById(user.getId());
            return userOp.isPresent() ? ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID " + user.getId() + " ya existe!") : ResponseEntity.status(HttpStatus.CREATED).body(this.userService.addUser(user));
        } else {
            Map<String, String> errors = new HashMap();

            for(FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errors);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUser(@PathVariable Integer id){
        Optional<User> user = this.userService.getUserById(id);
        return user != null && user.get().getId() != 0 ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con el ID "+ id + " no fue encontrado.");
    }

    @GetMapping
    public List<User> getUsers(){

        return this.userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet( @PathVariable Integer id){
        Optional<User> petFind = this.userService.getUserById(id);
        if (petFind.isEmpty()) {
            this.userService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body("El usuario con el ID " + id + " fue eliminado correctamente.");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el id " + id + " no se encuentra registrado.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPet(@Validated @PathVariable Integer id, @RequestBody User editUser, BindingResult result){
        if(!result.hasErrors()){
            if(!result.hasErrors()){
                Optional<User> userFind = this.userService.getUserById(id);
                return !userFind.isPresent() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con el ID " + id + " no existe!") : ResponseEntity.ok(this.userService.editUser(id, editUser));
            }else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el id " + id + " no se encuentra registrado.");
            }
        }else {
            Map<String, String> errors = new HashMap<>();

            for(FieldError error : result.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
    }

}
