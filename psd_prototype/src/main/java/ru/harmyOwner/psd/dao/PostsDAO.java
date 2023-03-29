package ru.harmyOwner.psd.dao;

import org.springframework.stereotype.Component;
import ru.harmyOwner.psd.models.Post;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostsDAO{

    private static int POSTS_COUNTER;

    List<Post> posts;

    {
        posts = new ArrayList<Post>();

        posts.add(new Post(++POSTS_COUNTER,"Post1"));
        posts.add(new Post(++POSTS_COUNTER,"Post2"));
        posts.add(new Post(++POSTS_COUNTER,"Post3"));
        posts.add(new Post(++POSTS_COUNTER,"Post4"));

    }

    public List<Post> all(){
        return posts;
    }

    public Post certain(int id){
        return posts.stream().filter(post -> post.getId() == id).findAny().orElse(null);
    }

    public void save(Post post){
        post.setId(++POSTS_COUNTER);
        posts.add(post);
    }

    public void update(int id, Post updatedPost){
        Post postToBeUpdated = certain(id);
        postToBeUpdated.setTittle(postToBeUpdated.getTittle());
    }

    public void delete(int id){
        posts.remove(certain(id));
    }


}
