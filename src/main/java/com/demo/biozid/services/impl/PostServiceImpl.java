package com.demo.biozid.services.impl;

import com.demo.biozid.dtos.PostDto;

import com.demo.biozid.models.Post;
import com.demo.biozid.models.User;
import com.demo.biozid.repos.LocationRepository;
import com.demo.biozid.repos.PostRepository;
import com.demo.biozid.services.PostService;
import com.demo.biozid.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;


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
        post.setId(dto.getId());
        post.setAuthor(user);
        post.setLocation(locationRepository.findById(dto.getLocation()).get());
        post.setTitle(dto.getTitle());
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Override
    public PostDto findById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if(post != null) {
            PostDto dto = new PostDto();
            dto.setId(id);
            dto.setLocation(post.getLocation().getId());
            dto.setTitle(post.getTitle());
            dto.setMarked(post.getMarked());
            return dto;
        }
        return new PostDto();
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        return postRepository.findAllByAuthor(user);
    }
}
