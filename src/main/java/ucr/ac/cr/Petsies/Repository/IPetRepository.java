package ucr.ac.cr.Petsies.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.cr.Petsies.Model.Pet;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Integer> {
}
