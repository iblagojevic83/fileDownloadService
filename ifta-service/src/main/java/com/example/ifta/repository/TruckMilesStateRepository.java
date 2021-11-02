package com.example.ifta.repository;

import com.example.ifta.entities.TruckDrivenMilesState;
import com.example.ifta.entities.VehicleMilesState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TruckMilesStateRepository extends JpaRepository<TruckDrivenMilesState, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT tdms FROM TruckDrivenMilesState tdms " +
            "WHERE (((CAST(:startDateTime AS OffsetDateTime) IS NULL)) OR (tdms.startDateTime >= :startDateTime))" +
            "AND (((CAST(:endDateTime AS OffsetDateTime) IS NULL)) OR (tdms.endDateTime >= :endDateTime))")
    List<VehicleMilesState> findBySearchParams(@Param("startDateTime") OffsetDateTime startDateTime,
                                               @Param("endDateTime") OffsetDateTime endDateTime);
}
