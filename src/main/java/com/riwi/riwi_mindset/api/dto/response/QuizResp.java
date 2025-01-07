package com.riwi.riwi_mindset.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizResp {
    private Long idQuiz;
    private String img;
    private String title;
    private String description;
    private Integer quantityQuestions;
    private Integer tries;
    private Integer passed;
    private Integer failed;
}
