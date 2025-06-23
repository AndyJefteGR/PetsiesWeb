package ucr.ac.cr.Petsies.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucr.ac.cr.Petsies.Model.Pet;
import ucr.ac.cr.Petsies.Model.User;
import ucr.ac.cr.Petsies.Repository.IPetRepository;
import ucr.ac.cr.Petsies.Repository.IUserRegister;


import java.util.List;
import java.util.Optional;


@Service
public class PetService {

    @Autowired
    IPetRepository iPetRepository;

    @Autowired
    private IUserRegister userRegister;

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

    public Pet editPet(Integer id, Pet user){
        Optional<Pet> userOptional = this.iPetRepository.findById(id);
        if (userOptional.isEmpty()) {
            return new Pet();
        }

        this.iPetRepository.deleteById(id);
        return this.iPetRepository.save(user);

    }

    public Pet addPetToUser(Integer userId, Pet pet) {
        Optional<User> userOptional = userRegister.findById(userId);

        if (userOptional.isEmpty()) {
            return null;
        }

        pet.setOwner(userOptional.get());
        return iPetRepository.save(pet);
    }

}
