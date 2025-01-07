package com.riwi.riwi_mindset.infraestructure.abstact_service;

import com.riwi.riwi_mindset.api.dto.request.ResultTestReq;
import com.riwi.riwi_mindset.api.dto.response.ResultTestResp;

public interface IResultTestService extends CrudService<ResultTestReq, ResultTestResp,Integer>{
    public String FIELD_BY_SORT = "Score";
}
