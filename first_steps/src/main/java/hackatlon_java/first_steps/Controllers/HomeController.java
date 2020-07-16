package hackatlon_java.first_steps.Controllers;

import hackatlon_java.first_steps.DTOs.CreateUserDTO;
import hackatlon_java.first_steps.DTOs.LoginRequest;
import hackatlon_java.first_steps.Security.UserDetailsServiceImpl;
import hackatlon_java.first_steps.Services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class HomeController {

    private AuthenticationManager authenticationManager;
    private MasterService masterService;
    private UserDetailsService userDetailsService;

    @Autowired
    public HomeController(AuthenticationManager authenticate, MasterService masterService, @Qualifier("custom") UserDetailsService userDetailsService) {
        this.authenticationManager = authenticate;
        this.masterService = masterService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("")
    public String home(){
        return "Index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public RedirectView login(@ModelAttribute LoginRequest loginRequest) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.
                    getUsername(), loginRequest.getPassword()));
        } catch (InternalAuthenticationServiceException | BadCredentialsException e) {
            return new RedirectView("login");
        }
        //final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        return new RedirectView("Index");
    }



    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody CreateUserDTO userDTO)
    {
        masterService.createUser(userDTO);
        return new ResponseEntity("User created", HttpStatus.OK);
    }

    public HomeController(MasterService masterService){
        this.masterService = masterService;
    }


}
