package studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import studentmanagement.entity.User;
import studentmanagement.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup/save")
    public String saveUser(@ModelAttribute User user) {

        userRepository.save(user);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user != null) {
            return "redirect:/dashboard";
        }

        return "redirect:/?error";
    }
}