package com.app.studenthub.repository;


import com.app.studenthub.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
    // You can define custom query methods here if needed

}
