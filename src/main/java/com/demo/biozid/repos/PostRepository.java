package com.demo.biozid.repos;

import com.demo.biozid.models.Post;
import com.demo.biozid.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long > {

    List<Post> findAllByAuthor(User user);

}