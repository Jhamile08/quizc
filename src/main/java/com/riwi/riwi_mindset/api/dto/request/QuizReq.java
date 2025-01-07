package com.riwi.riwi_mindset.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizReq {
    private String img;
    @NotNull(message = "El tipo de pregunta es requerida")
    private String title;
    @NotNull(message = "la descripcion de quiz es requerida")
    private String description;
    @NotNull(message = "El numero de preguntas es requerida")
    private Integer quantityQuestions;

}
