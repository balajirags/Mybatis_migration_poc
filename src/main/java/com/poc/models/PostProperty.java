package com.poc.models;

/**
 * Created by gbalaji on 12/09/14.
 */
public class PostProperty
{
    private Integer totalComments;
    private String name;

    public PostProperty(Integer totalComments, String name)
    {
        this.totalComments = totalComments;
        this.name = name;
    }

    public Integer getTotalComments()
    {
        return totalComments;
    }

    public void setTotalComments(Integer totalComments)
    {
        this.totalComments = totalComments;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
