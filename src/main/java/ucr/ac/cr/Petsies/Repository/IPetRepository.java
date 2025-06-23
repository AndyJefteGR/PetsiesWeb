package ucr.ac.cr.Petsies.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucr.ac.cr.Petsies.Model.Pet;

public interface IPetRepository extends JpaRepository<Pet, Integer> {
}
