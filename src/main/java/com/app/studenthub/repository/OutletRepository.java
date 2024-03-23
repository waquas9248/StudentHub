package com.app.studenthub.repository;

import com.app.studenthub.model.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.app.studenthub.util.OutletType;
@Repository
public interface OutletRepository extends JpaRepository<Outlet, Long> {
    List<Outlet> findAllByRatingGreaterThanEqual(Float rating);

    Optional<Outlet> findByName(String name);
    // You can define custom query methods here if needed

    List<Outlet> findAllByOutletType(OutletType outletType);

}
