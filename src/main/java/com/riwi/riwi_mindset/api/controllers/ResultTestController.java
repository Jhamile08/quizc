package com.riwi.riwi_mindset.api.controllers;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.riwi.riwi_mindset.api.dto.request.ResultTestReq;
import com.riwi.riwi_mindset.api.dto.response.ResultTestResp;
import com.riwi.riwi_mindset.infraestructure.abstact_service.IResultTestService;
import com.riwi.riwi_mindset.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/result")
@AllArgsConstructor
public class ResultTestController {
    
    private final IResultTestService resultTestService;
    @GetMapping
    public ResponseEntity<Page<ResultTestResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
            if (Objects.isNull(sortType)) sortType = SortType.NONE;
        return ResponseEntity.ok(this.resultTestService.getAll(page - 1, size, sortType));
    }

    @PostMapping
    public ResponseEntity<ResultTestResp> insert(
            @Validated @RequestBody ResultTestReq request) {
        return ResponseEntity.ok(this.resultTestService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ResultTestResp> update(
            @Validated @RequestBody ResultTestReq request,
            @PathVariable Integer id) {
        return ResponseEntity.ok(this.resultTestService.update(request, id));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.resultTestService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
