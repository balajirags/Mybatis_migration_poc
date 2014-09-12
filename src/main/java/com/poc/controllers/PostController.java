package com.poc.controllers;

import com.poc.models.Post;
import com.poc.models.PostProperty;
import com.poc.repository.PostRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository repository;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<Post> index() {
        System.out.println( "There are totally "+ repository.getPosts().size() + " posts");
        return repository.getPosts();
    }

    @RequestMapping(method=RequestMethod.POST)
    public String postDetails() {
        Random ran = new Random();
        Post post = new Post(ran.nextInt(6) + 5, UUID.randomUUID().toString(), new PostProperty(1, "test"));
        repository.addPost(post);
        return "There are totally "+ repository.getPosts().size() + " posts";
    }


}
