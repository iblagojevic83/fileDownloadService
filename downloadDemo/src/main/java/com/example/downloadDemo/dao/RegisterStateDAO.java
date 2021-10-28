package com.example.downloadDemo.dao;

import com.example.downloadDemo.entities.RegisterState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterStateDAO extends JpaRepository<RegisterState, Long> {

    RegisterState findById(String stateId);
}
