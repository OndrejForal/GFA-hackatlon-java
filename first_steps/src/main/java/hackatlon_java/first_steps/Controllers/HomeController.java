package hackatlon_java.first_steps.Controllers;

import hackatlon_java.first_steps.DTOs.CreateUserDTO;
import hackatlon_java.first_steps.DTOs.LoginRequest;
import hackatlon_java.first_steps.Entities.AppUser;
import hackatlon_java.first_steps.Services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import hackatlon_java.first_steps.DTOs.QuestionDTO;
import hackatlon_java.first_steps.Services.QuestionService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("")
public class HomeController extends BaseController{

    private AuthenticationManager authenticationManager;
    private MasterService masterService;
    private UserDetailsService userDetailsService;
    private final QuestionService questionService;
    private static ArrayList<QuestionDTO> q;
    private int index = 0;


    @Autowired
    public HomeController(AuthenticationManager authenticate, MasterService masterService, @Qualifier("custom") UserDetailsService userDetailsService, QuestionService questionService1, QuestionService questionService) {
        this.authenticationManager = authenticate;
        this.masterService = masterService;
        this.userDetailsService = userDetailsService;
        this.questionService = questionService;
        q = this.questionService.getQuestion();
    }

    @GetMapping("/")
    public String home() {
        return "Index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.
                    getUsername(), loginRequest.getPassword()));
        } catch (InternalAuthenticationServiceException | BadCredentialsException e) {
            return "redirect:login";
        }
        //final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        return "redirect:Index";

    }

    

    @GetMapping("/quiz")
    public String getQuiz(Model m) {

        m.addAttribute("quizz", q.get(index));

        index = 0;
        if (q.size() != 0){
            m.addAttribute("quizz",q.get(index));
            return "quiz";
        }

        return "quiz";
    }

    @PostMapping("/quiz")

    public RedirectView getQuiz(Model m, Integer point){
        index ++;

        Optional<AppUser> ap = masterService.findUser(getUserId());
        masterService.countPoint(point,ap);

        if (index >= q.size()){

            return new RedirectView("/result");
        }
        return new RedirectView("quiz");
    }

    @GetMapping("/result")
    public String getResult() {
        return "Index";
    }
}
