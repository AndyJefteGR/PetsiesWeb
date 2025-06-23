package ucr.ac.cr.Petsies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Petsies.Model.Pet;
import ucr.ac.cr.Petsies.Repository.IPetRepository;


import java.util.ArrayList;


@Service
public class PetService {

    @Autowired
    IPetRepository IpetRepository;

    public Pet addPet(Pet pet){
        return this.IpetRepository.add(pet);

    }

    public Pet findPet(Integer id){

        return this.IpetRepository.findPet(id);

    }

    public ArrayList<Pet> getPets(){

        return this.IpetRepository.getAllPets();

    }

    public Pet deleteById(Integer id){

        return this.IpetRepository.deleteByID(id);
    }

    public Pet editPet(Integer id, Pet editPet){
        return this.IpetRepository.editPet(id, editPet);
    }

    public boolean existPetId(Integer id){
        return this.IpetRepository.existPetId(id);
    }










}
