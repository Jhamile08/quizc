package com.riwi.riwi_mindset.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.riwi_mindset.domain.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    
}
