package com.demo.biozid.services;

import com.demo.biozid.dtos.PostDto;
import com.demo.biozid.dtos.UserRegistrationDto;
import com.demo.biozid.models.Post;
import com.demo.biozid.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PostService  {

    Post save(PostDto postDto);
}
