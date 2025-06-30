package ucr.ac.cr.Petsies.Model;

public class OwnerDTO {
    private Integer id;
    private String name;
    private String num_tel;

    public OwnerDTO(Integer id, String name, String num_tel) {
        this.id = id;
        this.name = name;
        this.num_tel = num_tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }
}
