package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post getPostById(long id);


    //returns the most liked posts
    List<Post> findAllByOrderByLikedByDesc();


    //returns the most recent posts
    List<Post> findAllByOrderByCreatedAtDesc();
}
