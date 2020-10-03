package com.demo.biozid.controllers;

import com.demo.biozid.dtos.PostDto;
import com.demo.biozid.models.Location;
import com.demo.biozid.models.Post;
import com.demo.biozid.repos.LocationRepository;
import com.demo.biozid.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("post")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostController {
    private final LocationRepository locationRepository;
    private final PostService postService;


    @ModelAttribute("post")
    public PostDto userRegistrationDto() {
        return new PostDto();
    }

    @ModelAttribute("locations")
    public List<Location> locationList() {
        return locationRepository.findAll();
    }
    @ModelAttribute("postList")
    public List<Post> personalPostList() {
        return postService.findAll();
    }

    @GetMapping
    public String newPostCreation(Model model) {
        return "create-post";
    }

    @GetMapping("list")
    public String listOfAllPost(Model model) {
        model.addAttribute("postList", postService.findAll());
        return "personal-list";
    }

    @GetMapping("edit/{id}")
    public String editPost(Model model, @PathVariable("id")Long id) {
        model.addAttribute("post", postService.findById(id) );
        return "create-post";
    }

    @GetMapping("delete/{id}")
    public String deletePost(Model model, @PathVariable("id")Long id) {
        postService.deleteById(id);
        return "personal-list";
    }


    @PostMapping
    public String savePost(@ModelAttribute("post") @Valid PostDto postDto, BindingResult result) {
        if (result.hasErrors()) return "create-post";
        postService.save(postDto);
        return "redirect:/post?success";
    }
}
