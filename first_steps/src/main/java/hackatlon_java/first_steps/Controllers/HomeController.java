package hackatlon_java.first_steps.Controllers;

import hackatlon_java.first_steps.DTOs.CreateUserDTO;
import hackatlon_java.first_steps.Services.MasterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class HomeController {

    private MasterService masterService;

    @GetMapping("")
    public String home(){
        return "Index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("register")
    public ResponseEntity createUser(@ModelAttribute CreateUserDTO userDTO)
    {
        masterService.createUser(userDTO);
        return new ResponseEntity("User created", HttpStatus.OK);

    }
    public HomeController(MasterService masterService){
        this.masterService = masterService;
    }
}
