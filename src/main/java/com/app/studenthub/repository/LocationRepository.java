package com.app.studenthub.repository;

import com.app.studenthub.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    // You can define custom query methods here if needed
}
