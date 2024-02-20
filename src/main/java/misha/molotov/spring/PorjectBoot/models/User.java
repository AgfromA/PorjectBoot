package misha.molotov.spring.PorjectBoot.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column()
    @NotBlank(message = "Name need correct")
    @Size(min = 2, max = 30, message = "range 2 - 30!")
    private String name;
    @Column
    @NotBlank(message = "Blank surname!")
    @Size(min = 2, max = 30, message = "range 2 - 30!")
    private String lastName;
    @Column
    @Email(message = "Uncorrect Email")
    @NotBlank(message = "Email!!!!!")
    private String email;


    public User() {
    }

    public User(Integer id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}