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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@Validated @RequestBody User user, BindingResult result){
        if (!result.hasErrors()){
            if(this.userService.existID(user.getId())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID " + user.getId() + " ya se encuentra registrada.");
            }else{
                User addUser = this.userService.addUser(user);
                return ResponseEntity.status(HttpStatus.CREATED).body(addUser);
            }

        }else{
            Map<String, String> errors = new HashMap<>();

            for(FieldError error : result.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUser(@PathVariable Integer id){
        User user = this.userService.findUser(id);
        return user != null && user.getId() != 0 ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con el ID "+ id + " no fue encontrado.");
    }

    @GetMapping
    public ArrayList<User> getUsers(){

        return this.userService.getUsers();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet( @PathVariable Integer id){
        if(this.userService.existID(id)){
            this.userService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("El usuario con el ID " + id + " fue eliminado correctamente.");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el id " + id + " no se encuentra registrado.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPet(@Validated @PathVariable Integer id, @RequestBody User editUser, BindingResult result){
        if(!result.hasErrors()){
            if(this.userService.existID(id)){
                return id != editUser.getId() ? ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el id " + id + " no coincide con el ingresado.") : ResponseEntity.ok(this.userService.editUser(id, editUser));
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
