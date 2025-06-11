package ucr.ac.cr.Petsies.Model;

public class Pet {

    private Integer idPet;
    private Integer age;
    private String name;
    private String description;
    private Double weight;


    public Pet() {
        this.idPet = 0;
        this.age = 0;
        this.name = "";
        this.description = "";
        this.weight = 0.0;
    }

    public Pet(Integer idPet, Integer age, String name, String description, Double weight) {
        this.idPet = idPet;
        this.age = age;
        this.name = name;
        this.description = description;
        this.weight = weight;
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
}
