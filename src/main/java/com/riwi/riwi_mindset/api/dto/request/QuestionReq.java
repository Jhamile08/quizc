package com.riwi.riwi_mindset.api.dto.request;

import java.util.List;

import com.riwi.riwi_mindset.utils.enums.TypeQuestion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class QuestionReq {
    @NotNull(message = "El tipo de pregunta es requerida")
    private int idQuiz;
    @NotBlank(message = "La pregunta es requerida")
    private String question;
    @NotNull(message = "La respuesta es requerida")
    private List<String> answers;
}
