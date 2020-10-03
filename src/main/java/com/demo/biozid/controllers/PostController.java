package com.demo.biozid.controllers;

import com.demo.biozid.dtos.PostDto;
import com.demo.biozid.dtos.UserRegistrationDto;
import com.demo.biozid.models.Location;
import com.demo.biozid.models.Post;
import com.demo.biozid.repos.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("post")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostController {
    private final LocationRepository locationRepository;

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
}
