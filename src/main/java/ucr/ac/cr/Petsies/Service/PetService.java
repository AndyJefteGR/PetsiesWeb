package ucr.ac.cr.Petsies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Petsies.Model.Pet;
import ucr.ac.cr.Petsies.Repository.IPetRepository;


import java.util.List;
import java.util.Optional;


@Service
public class PetService {

    @Autowired
    IPetRepository iPetRepository;

    public Pet addPet(Pet pet){
        return this.iPetRepository.save(pet);

    }

    public Optional<Pet> findPet(Integer id){

        return this.iPetRepository.findById(id);

    }

    public List<Pet> getPets(){

        return this.iPetRepository.findAll();

    }

    public void deletePetById(Integer id){

        this.iPetRepository.deleteById(id);

    }











}
