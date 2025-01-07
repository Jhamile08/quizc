package com.riwi.riwi_mindset.infraestructure.abstact_service;

import com.riwi.riwi_mindset.api.dto.request.QuestionReq;
import com.riwi.riwi_mindset.api.dto.response.QuestionResp;

public interface IQuestionService extends CrudService<QuestionReq,QuestionResp, Integer> {
    public final String FIELD_BY_SORT = "question";
}
