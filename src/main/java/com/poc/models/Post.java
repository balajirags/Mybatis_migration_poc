package com.poc.models;


import java.lang.Integer;
import java.lang.String;
import java.util.HashMap;

public class Post {
    private Integer id;
    private String name;
    private PostProperty postProperty;

    public Post(Integer id, String name, PostProperty postProperty)
    {
        this.id = id;
        this.name = name;
        this.postProperty = postProperty;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public PostProperty getPostProperty()
    {
        return postProperty;
    }

    public void setPostProperty(PostProperty postProperty)
    {
        this.postProperty = postProperty;
    }
}
