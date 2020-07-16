package hackatlon_java.first_steps.DTOs;

import lombok.Getter;
import lombok.Setter;

public class QuestionDTO {
    @Getter
    @Setter
    private String question;
    private String description;
    private String title;

}
