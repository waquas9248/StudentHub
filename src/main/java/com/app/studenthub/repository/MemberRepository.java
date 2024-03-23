package com.app.studenthub.repository;


import com.app.studenthub.model.Group;
import com.app.studenthub.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // You can define custom query methods here if needed

    List<Member> findAllByUser_Id(Long userId);
    List<Member> findAllByGroup_Id(Long groupId);

}
