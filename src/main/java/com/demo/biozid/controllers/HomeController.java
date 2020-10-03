package com.demo.biozid.controllers;
import com.demo.biozid.models.User;
import com.demo.biozid.repos.PostRepository;
import com.demo.biozid.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController extends BaseController {

    private final PostRepository postRepository;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("postList", postRepository.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}