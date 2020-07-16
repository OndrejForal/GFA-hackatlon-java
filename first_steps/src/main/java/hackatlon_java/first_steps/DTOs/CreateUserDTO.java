package hackatlon_java.first_steps.DTOs;

import lombok.Getter;

@Getter
public class CreateUserDTO {
    private String name;
    private String email;
    private String password;

    public CreateUserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
