package com.riwi.riwi_mindset.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.riwi_mindset.domain.entities.ResultTest;

@Repository
public interface ResultTestRepository extends JpaRepository<ResultTest, Integer>{
    
}
