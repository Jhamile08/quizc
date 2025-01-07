package com.riwi.riwi_mindset.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultTestResp {
    private int idResultTest;
    private String id_coder;
    private String result;
}
