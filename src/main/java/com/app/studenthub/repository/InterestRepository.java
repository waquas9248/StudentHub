package com.app.studenthub.repository;


import com.app.studenthub.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
    // You can define custom query methods here if needed
}
