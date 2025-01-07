package com.riwi.riwi_mindset.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.riwi_mindset.api.dto.request.QuestionReq;
import com.riwi.riwi_mindset.api.dto.response.QuestionResp;
import com.riwi.riwi_mindset.infraestructure.abstact_service.IQuestionService;
import com.riwi.riwi_mindset.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {
    @Autowired
    private final IQuestionService questionService;

    @CrossOrigin(origins = "http://127.0.0.1:5502")
    @GetMapping
    public ResponseEntity<Page<QuestionResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
                if (Objects.isNull(sortType)) sortType = SortType.NONE;

                return ResponseEntity.ok(this.questionService.getAll(page -1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<QuestionResp> get(
            @PathVariable Integer id) {
        return ResponseEntity.ok(this.questionService.get(id));
    }

    @PostMapping
    public ResponseEntity<QuestionResp> insert(
            @Validated @RequestBody QuestionReq request) {
        return ResponseEntity.ok(this.questionService.create(request));
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<QuestionResp> update(
            @Validated @RequestBody QuestionReq request,
            @PathVariable Integer id) {
        return ResponseEntity.ok(this.questionService.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.questionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
