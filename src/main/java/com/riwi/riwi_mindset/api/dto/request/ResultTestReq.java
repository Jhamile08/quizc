package com.riwi.riwi_mindset.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class ResultTestReq {
    @NotBlank( message = "El id coder es requerido es requerido")
    private String id_coder;
    @NotBlank( message = "El resultado es requerido")
    private String result;
}
