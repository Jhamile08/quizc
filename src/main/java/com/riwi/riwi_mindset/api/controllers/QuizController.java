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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.riwi_mindset.api.dto.request.QuizReq;
import com.riwi.riwi_mindset.api.dto.response.QuizResp;
import com.riwi.riwi_mindset.infraestructure.abstact_service.IQuizService;
import com.riwi.riwi_mindset.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class QuizController {
    @Autowired
    private final IQuizService quizService;

    @GetMapping
    public ResponseEntity<Page<QuizResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType))
            sortType = SortType.NONE;

        return ResponseEntity.ok(this.quizService.getAll(page - 1, size, sortType));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<QuizResp> get(
            @PathVariable Long id) {
        return ResponseEntity.ok(this.quizService.get(id));
    }

    @PostMapping
    public ResponseEntity<QuizResp> insert(
            @Validated @RequestBody QuizReq request) {
        return ResponseEntity.ok(this.quizService.create(request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.quizService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
