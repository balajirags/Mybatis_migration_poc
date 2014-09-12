package com.poc.repository;

import com.google.gson.Gson;
import com.poc.models.Post;
import com.poc.models.PostProperty;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.SimpleJsonParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepository {

    @Autowired
    protected JdbcTemplate jdbc;

    public List<Post> getPosts() {
        return jdbc.queryForObject("SELECT * FROM post", POST_MAPPER);
    }


    public void addPost(Post post){
        Gson gson = new Gson();
        jdbc.update("insert into post values (?,?,?)",post.getId(),post.getName(), constructJsonType(gson.toJson(post.getPostProperty())));
    }

    private static final RowMapper<List<Post>> POST_MAPPER = new RowMapper<List<Post>>() {
        public List<Post> mapRow(ResultSet rs, int rowNum) throws SQLException {
            List<Post> postArrayList = new ArrayList<Post>();
            do{
                PostProperty properties = new Gson().fromJson(rs.getString("properties"), PostProperty.class);
                Post post = new Post(rs.getInt("id"), rs.getString("name"), properties );
                postArrayList.add(post);
            }while(rs.next());

            return postArrayList;
        }
    };

    private static PGobject constructJsonType(String json){
        PGobject pgObject = new PGobject();
        pgObject.setType("json");
        try {
            pgObject.setValue(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pgObject;
    }

}