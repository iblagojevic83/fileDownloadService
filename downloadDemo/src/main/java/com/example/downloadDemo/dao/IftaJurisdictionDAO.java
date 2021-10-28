package com.example.downloadDemo.dao;

import com.example.downloadDemo.entities.IftaJurisdiction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IftaJurisdictionDAO extends JpaRepository<IftaJurisdiction, Long> {

    IftaJurisdiction findById(String id);
}
