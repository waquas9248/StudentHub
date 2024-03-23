package com.app.studenthub.service;

import com.app.studenthub.model.Post;
import com.app.studenthub.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getAllPostsByUser(Long id) {
        return postRepository.findAllByUser_Id(id);
    }

    public List<Post> getAllPostsByGroup(Long id) {
        return postRepository.findAllByGroup_Id(id);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post postDetails) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();
            existingPost.setTitle(postDetails.getTitle());
            existingPost.setBody(postDetails.getBody());
            existingPost.setUser(postDetails.getUser());
            existingPost.setGroup(postDetails.getGroup());
            existingPost.setStatus(postDetails.getStatus());
            existingPost.setCreatedAt(postDetails.getCreatedAt());
            return postRepository.save(existingPost);
        } else {
            throw new RuntimeException("Post not found with id: " + id);
        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
