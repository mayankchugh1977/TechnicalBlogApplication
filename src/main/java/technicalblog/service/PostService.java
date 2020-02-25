package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    @PersistenceUnit(unitName="techblog")
    private EntityManagerFactory emf;

    public PostService(){
        System.out.println("** PostService **");
    }

    public List<Post> getAllPosts() {

        return repository.getAllPosts();
    }

    public Post getOnePost() {
        return repository.getLatestPosts();
    }

    public void createPost (Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post: "+newPost);
    }

    public Post getPost(Integer postId) {
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
        System.out.println("New Post: "+updatedPost);
    }

    public void deletePost(Integer postId) {
        repository.deletePost(postId);
    }
}
