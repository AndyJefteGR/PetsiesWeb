package ucr.ac.cr.Petsies.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.ac.cr.Petsies.Model.Pet;
import ucr.ac.cr.Petsies.Model.Pet;
import ucr.ac.cr.Petsies.Service.PetService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/pets")
public class Petcontroller {

    @Autowired
    PetService petService;

    @PostMapping
    public Pet addUser(@RequestBody Pet pet){
        return this.petService.addPet(pet);

    }

    @GetMapping("/{id}")
    public Pet findPet(@PathVariable Integer id){

        return this.petService.findPet(id);
    }

    @GetMapping
    public ArrayList<Pet> getUsers(){

        return this.petService.getPets();
    }

    @DeleteMapping("/{id}")
    public Pet deletePet( @PathVariable Integer id){

        return this.petService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Pet editPet( @PathVariable Integer id, @RequestBody Pet pet){

        return this.petService.editPet(id, pet);

    }


}
