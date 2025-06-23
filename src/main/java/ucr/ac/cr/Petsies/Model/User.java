package ucr.ac.cr.Petsies.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String name;
    private String password;
    private String email;
    private String num_tel;

    public User() {

        this.id = 0;
        this.name = "";
        this.password = "";
        this.email = "";
        this.num_tel = "";

    }

    public User(Integer id, String name, String password, String email, String num_tel) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
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

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }


    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String getNum_tel() {

        return num_tel;

    }

    public void setNum_tel(String num_tel) {

        this.num_tel = num_tel;

    }
}
