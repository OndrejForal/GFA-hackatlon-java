package hackatlon_java.first_steps.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Question {
    @Id
    private long ID;
    private String question;
    private String url;
    private String title;
    private String description;
}
