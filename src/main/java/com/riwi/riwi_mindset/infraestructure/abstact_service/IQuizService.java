package com.riwi.riwi_mindset.infraestructure.abstact_service;

import com.riwi.riwi_mindset.api.dto.request.QuizReq;
import com.riwi.riwi_mindset.api.dto.response.QuizResp;

public interface IQuizService extends CrudService<QuizReq,QuizResp, Integer> {
    public final String FIELD_BY_SORT = "quiz";
}
