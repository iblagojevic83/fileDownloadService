package com.example.ifta.repository;

import com.example.ifta.entities.RegisterState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterStateRepository extends JpaRepository<RegisterState, Long> {

    RegisterState findById(String stateId);
}
