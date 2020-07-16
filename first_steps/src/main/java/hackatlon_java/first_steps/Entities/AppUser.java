package hackatlon_java.first_steps.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private ProfileUser profileUser;

    public AppUser(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public AppUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public AppUser() {
    }
}
