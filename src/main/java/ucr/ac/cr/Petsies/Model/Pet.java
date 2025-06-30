package ucr.ac.cr.Petsies.Model;

import jakarta.persistence.*;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pet")
    private Integer idPet;
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "species", length = 10)
    private String species;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "photo_url", length = 255)
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Pet() {
        this.idPet = 0;
        this.age = 0;
        this.name = "";
        this.description = "";
        this.species = "";
        this.weight = 0.0;
        this.photoUrl = "";
    }

    public Pet(Integer idPet, Integer age, String name, String description, Double weight, String photoUrl, String species) {
        this.idPet = idPet;
        this.age = age;
        this.name = name;
        this.description = description;
        this.species = species;
        this.weight = weight;
        this.photoUrl = photoUrl;
    }



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
