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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("")
    public String fundAccountCategoryList(Model model) {
        return "create-post";
    }


    @PostMapping
    public String registerUserAccount(@ModelAttribute("post") @Valid PostDto postDto, BindingResult result) {

        if (result.hasErrors()) return "create-post";
        postService.save(postDto);
        return "redirect:/create-post?success";
    }
}
