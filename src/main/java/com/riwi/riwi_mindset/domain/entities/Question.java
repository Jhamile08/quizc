package com.riwi.riwi_mindset.domain.entities;

import java.util.Collections;
import java.util.List;

import com.riwi.riwi_mindset.utils.enums.TypeQuestion;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "question")
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuestion;
    @Column(name = "id_quiz")
    private int idQuiz;
    @Column(nullable = false)
    private String question;
    @Column(nullable = false)
    @ElementCollection
    @OrderColumn
    @CollectionTable(name = "options")
    private List<String> answers;

    public Question(String question, int idQuiz, List<String> answers){
        this.question = question;
        this.idQuiz = idQuiz;
        this.answers = answers;
        Collections.shuffle(answers);
    }
}
