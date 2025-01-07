package com.riwi.riwi_mindset.infraestructure.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.riwi.riwi_mindset.api.dto.request.ResultTestReq;
import com.riwi.riwi_mindset.api.dto.response.ResultTestResp;
import com.riwi.riwi_mindset.domain.entities.ResultTest;
import com.riwi.riwi_mindset.domain.repositories.ResultTestRepository;
import com.riwi.riwi_mindset.infraestructure.abstact_service.IResultTestService;
import com.riwi.riwi_mindset.utils.enums.SortType;
import com.riwi.riwi_mindset.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResultTestService implements IResultTestService{
     @Autowired
    private final ResultTestRepository resultTestRepository;

    @Override
    public ResultTestResp create(ResultTestReq request) {
        ResultTest resultTest = this.requestToEntity(request);
        resultTest.setId_coder(request.getId_coder());
        resultTest.setResult(request.getResult());

        return this.entityToResp(this.resultTestRepository.save(resultTest));

    }

    @Override
    public void delete(Integer id) {
        this.resultTestRepository.delete(this.find(id));
        
    }

    @Override
    public ResultTestResp get(Integer id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public Page<ResultTestResp> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.resultTestRepository.findAll(pagination)
                .map(this::entityToResp);
    }

    @Override
    public ResultTestResp update(ResultTestReq request, Integer id) {
        ResultTest resultTest = this.find(id);
        resultTest = this.requestToEntity(request);

        resultTest.setIdResultTest(id);
        resultTest.setId_coder(request.getId_coder());
        resultTest.setResult(request.getResult());
       
        return this.entityToResp(this.resultTestRepository.save(resultTest));

    }
    private ResultTest requestToEntity(ResultTestReq request) {
        ResultTest resultTest = new ResultTest();
        resultTest.setId_coder(request.getId_coder());
        resultTest.setResult(request.getResult());
        return resultTest;
    }
    private ResultTestResp entityToResp(ResultTest entity){

        return ResultTestResp.builder()
                    .idResultTest(entity.getIdResultTest())
                    .id_coder(entity.getId_coder())
                    .result(entity.getResult())
                    .build();

    }    
  
    private ResultTest find(Integer id) {
        return this.resultTestRepository.findById(id)
        .orElseThrow(()-> new BadRequestException("No hay puntahes con el id suministrado"));
    }
       
}
