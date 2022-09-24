package payment.com.api.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import payment.com.api.payment.models.LoginUser;
import payment.com.api.payment.models.User;
import payment.com.api.payment.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping("/list")
    public Iterable<User> listUsers() {
        return us.listUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return us.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginUser form) {
        return us.loginUser(form);
    }

}