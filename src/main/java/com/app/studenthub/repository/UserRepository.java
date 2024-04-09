package com.app.studenthub.repository;

import com.app.studenthub.model.User;
import com.app.studenthub.util.YearOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstName(String firstName);

    List<User> findAllByLastName(String lastName);

    List<User> findAllByCountry(String country);

    List<User> findAllByMajor(String major);

    List<User> findAllByYearOfStudy(YearOfStudy yearOfStudy);

    Optional<User> findByEmail(String email);

    Optional<User> findBySecondaryEmail(String secondaryEmail);


    List<User> findAllByRole_Id(Long roleId);

    @Query("SELECT u FROM User u JOIN u.interests i WHERE i.id = :interestId")
    List<User> findAllByInterest_Id(Long interestId);

    @Query("SELECT u FROM User u JOIN u.connections c WHERE c.id = :connectionId")
    List<User> findAllByConnection_Id(Long connectionId);
    // You can define custom query methods here if needed

}
