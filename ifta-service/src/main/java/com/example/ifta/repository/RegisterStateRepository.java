package com.example.ifta.repository;

import com.example.ifta.entities.RegisterState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RegisterStateRepository extends JpaRepository<RegisterState, Long> {

    @Transactional(readOnly = true)
    @Query("select state from RegisterState state where state.id = :id")
    Optional<RegisterState> findByid(@Param("id") Long stateId);

}
