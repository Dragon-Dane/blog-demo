package com.demo.biozid.services.impl;

import com.demo.biozid.dtos.PostDto;
import com.demo.biozid.dtos.UserRegistrationDto;
import com.demo.biozid.models.Post;
import com.demo.biozid.models.Role;
import com.demo.biozid.models.User;
import com.demo.biozid.repos.LocationRepository;
import com.demo.biozid.repos.PostRepository;
import com.demo.biozid.repos.UserRepository;
import com.demo.biozid.services.PostService;
import com.demo.biozid.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PostServiceImpl implements PostService {

    private final LocationRepository locationRepository;
    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public Post save(PostDto dto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        Post post = new Post();
        post.setAuthor(user);
        post.setLocation(locationRepository.findById(dto.getLocation()).get());
        post.setTitle(dto.getTitle());
        Post savedPost = postRepository.save(post);
        return savedPost;
    }
}
