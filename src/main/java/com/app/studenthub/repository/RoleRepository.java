package com.app.studenthub.repository;

import com.app.studenthub.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.app.studenthub.util.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByType(UserRole type);
    // You can define custom query methods here if needed

}
