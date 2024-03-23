package com.app.studenthub.repository;

import com.app.studenthub.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

    List<Attendee> findByUserId(Long userId);

    List<Attendee> findByEventId(Long eventId);
}
