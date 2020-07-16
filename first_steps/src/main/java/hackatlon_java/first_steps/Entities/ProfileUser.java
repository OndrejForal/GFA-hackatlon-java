package hackatlon_java.first_steps.Entities;

import hackatlon_java.first_steps.Entities.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ProfileUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long Id;

    int testResult;

    @OneToOne(cascade= CascadeType.ALL)
    private AppUser appUser;

    public ProfileUser() {
    }

    public ProfileUser(int testResult) {
    this.testResult = testResult;
    }

}
