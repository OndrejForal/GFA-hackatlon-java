package hackatlon_java.first_steps.DTOs;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {
    public String name;
    public String email;
    public String password;

    public CreateUserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public CreateUserDTO(){    }
}
