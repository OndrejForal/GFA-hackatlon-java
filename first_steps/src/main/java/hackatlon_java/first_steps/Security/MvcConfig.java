package hackatlon_java.first_steps.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Index");
        //registry.addViewController("/").setViewName("home");
        //registry.addViewController("/hello").setViewName("hello");
        //registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");


    }

}