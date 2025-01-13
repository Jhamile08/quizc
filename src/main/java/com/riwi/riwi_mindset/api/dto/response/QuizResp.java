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
    private Long id;
    private String img;
    private String title;
    private String description;
    private Integer quantityQuestions;

}
