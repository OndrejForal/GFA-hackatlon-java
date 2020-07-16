package hackatlon_java.first_steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FirstStepsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstStepsApplication.class, args);
    }
}