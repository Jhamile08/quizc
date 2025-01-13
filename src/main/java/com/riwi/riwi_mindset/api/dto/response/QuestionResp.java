package com.riwi.riwi_mindset.api.dto.response;

import java.util.List;

import com.riwi.riwi_mindset.domain.entities.Quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResp {
    private int idQuestion;
    private Quiz quiz;
    private String question;
    private List<String> answers;
}
