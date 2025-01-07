package com.riwi.riwi_mindset.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data  
@NoArgsConstructor 
@AllArgsConstructor 
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuiz;

    private String img;

    private String title;

    private String description;

    @Column(name = "quantity_questions")
    private Integer quantityQuestions;

    private Integer tries = 0;

    private Integer passed = 0;

    private Integer failed = 0;
}
