package tbpapi.thebestprototypeapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tbpapi.thebestprototypeapi.Exceptions.NoUserFoundException;
import tbpapi.thebestprototypeapi.Exceptions.RegistrationErrorException;
import tbpapi.thebestprototypeapi.Models.User;
import tbpapi.thebestprototypeapi.Repositories.UserRepository;
import tbpapi.thebestprototypeapi.Services.AuthService;
import tbpapi.thebestprototypeapi.Services.UpdateService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository repo;

    @Autowired
    AuthService authService;
    @Autowired
    UpdateService updateService;

    @GetMapping("get-all")
    public List<User> getAllUsers(){
        List<User> employees = new ArrayList<>();
        Streamable.of(repo.findAll())
                .forEach(employees::add);
        return employees;
    }

    @PostMapping("update-location")
    public ResponseEntity UpdateLocation(@RequestBody User user){
        try {
            User userfromdb = updateService.updateLocation(user);
            return ResponseEntity.ok().body(userfromdb);
        } catch (NoUserFoundException error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @PostMapping("update-signal")
    public ResponseEntity UpdateSignal(@RequestBody User user){
        try {
            User userfromdb = updateService.updateSignal(user);
            return ResponseEntity.ok().body(userfromdb);
        } catch (NoUserFoundException error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }

    @PostMapping("sign-up")
    public ResponseEntity<?> SignUp(@RequestBody User user) {
        try {
            User userfromdb = authService.signUp(user);
            return ResponseEntity.ok().body(userfromdb);
        } catch (RegistrationErrorException error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
    @PostMapping("sign-in")
    public ResponseEntity<?> SignIn(@RequestBody User user){
        try {
            User userfromdb = authService.signIn(user);
            return ResponseEntity.ok().body(userfromdb);
        } catch (NoUserFoundException error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
