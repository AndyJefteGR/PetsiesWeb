package ucr.ac.cr.Petsies.Model;

public class PetDTO {
    private Integer idPet;
    private Integer age;
    private String name;
    private String description;
    private String specie;
    private Double weight;
    private String photoUrl;
    private OwnerDTO owner;



    public PetDTO(Integer idPet, Integer age, String name, String description, Double weight, String photoUrl, OwnerDTO owner, String specie) {
        this.idPet = idPet;
        this.age = age;
        this.name = name;
        this.description = description;
        this.specie = specie;
        this.weight = weight;
        this.photoUrl = photoUrl;
        this.owner = owner;

    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
