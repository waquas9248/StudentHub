package com.app.studenthub.repository;


import com.app.studenthub.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
//    @Query("SELECT g FROM Group g JOIN g.users u WHERE u.id = :userId")
//    List<Group> findGroupsByUserId(@Param("userId") Long userId);
//    // You can define custom query methods here if needed
}
