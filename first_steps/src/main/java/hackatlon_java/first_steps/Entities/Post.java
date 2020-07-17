package hackatlon_java.first_steps.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String post;
    private String name;
    private int score;
    private LocalDate date;
    public Post(String post){
        this.post=post;
        this.score=1;
        this.date = LocalDate.now();
    }
    public Post(){

    }
    public Post(String post, String name) {
        this.post=post;
        this.name = name;
        this.score=1;
        this.date = LocalDate.now();
    }
}