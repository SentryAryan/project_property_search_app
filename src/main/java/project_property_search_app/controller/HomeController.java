package project_property_search_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // This will render home.jsp located in WEB-INF/views
    }

    @GetMapping("/openloginpage")
    public String openLoginPage() {
        return "login"; // This will render login.jsp
    }
    @GetMapping("/signup")
    public String openSignupPage() {
        return "signup"; // This will render signup.jsp
    }
}