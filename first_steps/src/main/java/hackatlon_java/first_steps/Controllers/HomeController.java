package hackatlon_java.first_steps.Controllers;

import hackatlon_java.first_steps.DTOs.CreateUserDTO;
import hackatlon_java.first_steps.DTOs.QuestionDTO;
import hackatlon_java.first_steps.Entities.Question;
import hackatlon_java.first_steps.Services.MasterService;
import hackatlon_java.first_steps.Services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("")
public class HomeController {

    private final QuestionService questionService;
    private MasterService masterService;
    private static ArrayList<QuestionDTO> q;
    private int index = 0;


    public HomeController(MasterService masterService, QuestionService questionService) {
        this.masterService = masterService;
        this.questionService = questionService;
        this.q=this.questionService.getQuestion();
    }

    @GetMapping("")
    public String home() {
        return "Index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity createUser(@Valid @ModelAttribute CreateUserDTO userDTO) {
        masterService.createUser(userDTO);
        return new ResponseEntity("User created", HttpStatus.OK);
    }

    @GetMapping("/quiz")
    public String getQuiz(Model m) {
        m.addAttribute("quizz",q.get(index));
        return "quiz";
    }

    @PostMapping("/quiz")
    public RedirectView getQuiz(Model m, int point){
        index ++;
        
        if (index == q.size()){
            return new RedirectView("/result");
        }
        return new RedirectView("quiz");
    }

    @GetMapping("/result")
    public String getResult(){
        return "Index";
    }
}
