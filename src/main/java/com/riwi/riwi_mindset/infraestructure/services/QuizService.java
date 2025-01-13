package com.riwi.riwi_mindset.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.riwi_mindset.api.dto.request.QuizReq;
import com.riwi.riwi_mindset.api.dto.response.QuizResp;
import com.riwi.riwi_mindset.domain.entities.Quiz;
import com.riwi.riwi_mindset.domain.repositories.QuizRepository;
import com.riwi.riwi_mindset.infraestructure.abstact_service.IQuizService;
import com.riwi.riwi_mindset.utils.enums.SortType;
import com.riwi.riwi_mindset.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class QuizService implements IQuizService {

    @Autowired
    private final QuizRepository quizRepository;

    @Override
    public QuizResp create(QuizReq request) {
        Quiz quiz = this.requestToEntity(request);
        return this.entityToResp(this.quizRepository.save(quiz));
    }

    @Override
    public QuizResp get(Long id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public void delete(Long id) {
        this.quizRepository.delete(this.find(id));
    }

    @Override
    public Page<QuizResp> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.quizRepository.findAll(pagination)
                .map(this::entityToResp);
    }

    private Quiz requestToEntity(QuizReq request) {
        Quiz quiz = new Quiz();
        quiz.setImg(request.getImg());
        quiz.setTitle(request.getTitle());
        quiz.setDescription(request.getDescription());
        quiz.setQuantityQuestions(request.getQuantityQuestions());
        return quiz;
    }

    private QuizResp entityToResp(Quiz entity) {
        QuizResp resp = new QuizResp();
        resp.setId(entity.getId());
        resp.setImg(entity.getImg());
        resp.setTitle(entity.getTitle());
        resp.setDescription(entity.getDescription());
        resp.setQuantityQuestions(entity.getQuantityQuestions());

        return resp;
    }

    private Quiz find(Long id) {
        return this.quizRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay quiz con el id suministrado"));
    }

}
