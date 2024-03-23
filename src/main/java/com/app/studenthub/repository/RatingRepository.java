package com.app.studenthub.repository;

import com.app.studenthub.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByOutlet_Id(Long id);

    // You can define custom query methods here if needed

    List<Rating> findAllByUser_Id(Long id);

}
