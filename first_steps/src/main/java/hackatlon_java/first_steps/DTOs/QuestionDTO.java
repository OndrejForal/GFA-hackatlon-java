package hackatlon_java.first_steps.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {

    private String question;
    private String description;
    private String title;
    private String url;

    public QuestionDTO(String question, String description, String title, String url) {
        this.question = question;
        this.description = description;
        this.title = title;
        this.url = url;
    }
}
