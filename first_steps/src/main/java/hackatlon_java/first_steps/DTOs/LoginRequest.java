package hackatlon_java.first_steps.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    String username;
    String password;
}
