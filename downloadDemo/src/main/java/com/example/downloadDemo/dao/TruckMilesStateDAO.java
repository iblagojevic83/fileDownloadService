package com.example.downloadDemo.dao;

import com.example.downloadDemo.entities.TruckDrivenMilesState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckMilesStateDAO extends JpaRepository<TruckDrivenMilesState, Long> {


    TruckDrivenMilesState findByTruckId(String truckId);
}
