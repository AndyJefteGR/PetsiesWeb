package ucr.ac.cr.Petsies.Model;

import jakarta.persistence.*;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPet;
    private Integer age;
    private String name;
    private String description;
    private String species;
    private Double weight;
    private String photoUrl;


    public Pet() {
        this.idPet = 0;
        this.age = 0;
        this.name = "";
        this.description = "";
        this.weight = 0.0;
        this.photoUrl = "";
    }

    public Pet(Integer idPet, Integer age, String name, String description, Double weight, String photoUrl) {
        this.idPet = idPet;
        this.age = age;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.photoUrl = photoUrl;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Integer getIdPet() {

        return idPet;

    }

    public void setIdPet(Integer idPet) {

        this.idPet = idPet;

    }

    public Integer getAge() {

        return age;

    }

    public void setAge(Integer age) {

        this.age = age;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Double getWeight() {

        return weight;

    }

    public void setWeight(Double weight) {

        this.weight = weight;

    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
