package com.demo.biozid.services;

import com.demo.biozid.dtos.PostDto;
import com.demo.biozid.models.Post;
import org.springframework.data.domain.Page;

import java.util.List;


public interface PostService  {

    Post save(PostDto postDto);
    PostDto findById(Long id);

    List<Post> findAll();
}
