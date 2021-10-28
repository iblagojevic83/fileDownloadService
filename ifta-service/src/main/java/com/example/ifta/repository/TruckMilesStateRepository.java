package com.example.ifta.repository;

import com.example.ifta.entities.TruckDrivenMilesState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TruckMilesStateRepository extends JpaRepository<TruckDrivenMilesState, Long> {

    Optional<TruckDrivenMilesState> findByTruckId(String truckId);
}
