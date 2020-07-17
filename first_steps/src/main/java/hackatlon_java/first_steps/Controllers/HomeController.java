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

    @GetMapping("/quiz/{id}")
    public String getQuiz(@PathVariable Integer id,Model m) {
        if (id == null){
            id =0;
        }
        m.addAttribute("quizz",q.get((int)id));
        return "quiz";
    }

    @PostMapping("/quiz/{id}")
    public RedirectView getQuiz(@RequestParam Integer id,Model m, int point){
        id ++;
        return new RedirectView("quiz/{id}");
    }


}
