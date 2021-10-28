package com.example.ifta.repository;

import com.example.ifta.entities.IftaJurisdiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IftaJurisdictionRepository extends JpaRepository<IftaJurisdiction, Long> {

    IftaJurisdiction findById(String id);
}
