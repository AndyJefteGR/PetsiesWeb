package ucr.ac.cr.Petsies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Petsies.Model.Pet;
import ucr.ac.cr.Petsies.Repository.PetRepository;


import java.util.ArrayList;


@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public Pet addPet(Pet pet){
        return this.petRepository.add(pet);

    }

    public Pet findPet(Integer id){

        return this.petRepository.findPet(id);

    }

    public ArrayList<Pet> getPets(){

        return this.petRepository.getAllPets();

    }

    public Pet deleteById(Integer id){

        return this.petRepository.deleteByID(id);
    }


    public Pet editPet(Integer id, Pet pet){

        return this.petRepository.editPet(id, pet);
    }

}
