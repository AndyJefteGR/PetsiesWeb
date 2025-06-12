package ucr.ac.cr.Petsies.Repository;

import org.springframework.stereotype.Repository;
import ucr.ac.cr.Petsies.Model.Pet;

import java.util.ArrayList;

@Repository
public class PetRepository {

    private ArrayList<Pet> petList;

    public PetRepository(ArrayList<Pet> listUser) {

        this.petList = new ArrayList<>();

    }

    public Pet add(Pet pet){

        this.petList.add(pet);
        return pet;

    }

    public Pet findPet(Integer id){

        for (Pet pet : petList) {

            if (pet.getIdPet() == id) {

                return pet;

            }
        }

        return new Pet();

    }

    public ArrayList<Pet> getAllPets(){
        return this.petList;
    }

    public Pet deleteByID(Integer id){

        Pet pet = this.findPet(id);

        if (pet.getIdPet()==null){

            return new Pet();

        }

        this.petList.remove(pet);
        return pet;

    }

    public Pet editPet (Integer id, Pet editPet){
        for (int i = 0; i < this.petList.size(); i++) {
            if (((Pet)this.petList.get(i)).getIdPet() == id){
                this.petList.set(i, editPet);
                return (Pet)this.petList.get(i);

            }
        }

        return new Pet();

    }

    public Boolean existPetId(Integer id) {
        for(int i = 0; i < this.petList.size(); ++i) {
            if (((Pet)this.petList.get(i)).getIdPet() == id) {
                return true;
            }
        }

        return false;
    }

}
