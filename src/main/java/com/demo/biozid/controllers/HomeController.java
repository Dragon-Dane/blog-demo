package com.demo.biozid.controllers;
import com.demo.biozid.repos.PostRepository;
import com.demo.biozid.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController extends BaseController {

    private final PostService postService;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("postList", postService.findAll());
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