package ucr.ac.cr.Petsies.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.Petsies.Model.Pet;
import ucr.ac.cr.Petsies.Service.PetService;

import java.util.*;

@RestController
@RequestMapping("/api/pets")
public class Petcontroller {

    @Autowired
    PetService petService;

    @PostMapping("/user/{id}/register")
    public ResponseEntity<?> registerPet(@Validated @PathVariable Integer id, @RequestBody Pet pet, BindingResult result) {
        if (!result.hasErrors()) {
            Pet savedPet = petService.addPetToUser(id, pet);

            if (savedPet == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Por favor ingrese toda la informacion.");
            }

            return ResponseEntity.ok(savedPet);
        } else {
            Map<String, String> errors = new HashMap<>();

            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPet(@PathVariable Integer id){
        Optional<Pet> pet = this.petService.findPet(id);
        return pet.isPresent() && pet.get().getIdPet() != 0 ? ResponseEntity.ok(pet) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("La mascota con el ID "+ id + " no fue encontrada.");
    }

    @GetMapping
    public List<Pet> getPets(){

        return this.petService.getPets();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet( @PathVariable Integer id){
        Optional<Pet> petFind = this.petService.findPet(id);
        if (petFind.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La mascota con la ID " + id + " no existe");
        } else {
            this.petService.deletePetById(id);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPet(@Validated @PathVariable Integer id, @RequestBody Pet editPet, BindingResult result){
        if(!result.hasErrors()){
            if(!result.hasErrors()){
                Optional<Pet> petFind = this.petService.findPet(id);
                return !petFind.isPresent() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("La mascota con el ID " + id + " no existe!") : ResponseEntity.ok(this.petService.editPet(id, editPet));
            }else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("La mascota con el id " + id + " no se encuentra registrada.");
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
