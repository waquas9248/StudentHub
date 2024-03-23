package com.app.studenthub.repository;

import com.app.studenthub.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByGroup_Id(Long id);
    // You can define custom query methods here if needed
    List<Post> findAllByUser_Id(Long id);
}
