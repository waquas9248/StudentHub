package com.app.studenthub.repository;


import com.app.studenthub.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByName(String name);
    // You can define custom query methods here if needed

    List<Event> findAllByEventEndTimeLessThanEqual(LocalDateTime eventEndTime);

    List<Event> findAllByEventStartTimeGreaterThanEqual(LocalDateTime eventStartTime);

    @Query("SELECT e FROM Event e WHERE e.eventEndTime > CURRENT_TIMESTAMP AND e.eventEndTime <= :endTime")
    List<Event> findAllByEventEndTimeGreaterThanCurrentTimeAndEventEndTimeLessThanEqual(LocalDateTime endTime);

}
