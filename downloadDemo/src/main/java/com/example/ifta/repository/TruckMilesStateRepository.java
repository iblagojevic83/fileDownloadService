package com.example.ifta.repository;

import com.example.ifta.entities.TruckDrivenMilesState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckMilesStateRepository extends JpaRepository<TruckDrivenMilesState, Long> {


    TruckDrivenMilesState findByTruckId(String truckId);
}
