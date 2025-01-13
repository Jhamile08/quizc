package com.riwi.riwi_mindset.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riwi.riwi_mindset.api.dto.request.QuestionReq;
import com.riwi.riwi_mindset.api.dto.response.QuestionResp;
import com.riwi.riwi_mindset.domain.entities.Question;
import com.riwi.riwi_mindset.domain.entities.Quiz;
import com.riwi.riwi_mindset.domain.repositories.QuestionRepository;
import com.riwi.riwi_mindset.domain.repositories.QuizRepository;
import com.riwi.riwi_mindset.infraestructure.abstact_service.IQuestionService;
import com.riwi.riwi_mindset.utils.enums.SortType;
import com.riwi.riwi_mindset.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class QuestionService implements IQuestionService {
    @Autowired
    private final QuestionRepository questionRepository;
    @Autowired
    private final QuizRepository quizRepository;

    @Override
    public QuestionResp create(QuestionReq request) {
        Question question = this.requestToEntity(request);
        return this.entityToResp(this.questionRepository.save(question));
    }

    @Override
    public void delete(Integer id) {
        this.questionRepository.delete(this.find(id));
    }

    @Override
    public QuestionResp get(Integer id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public Page<QuestionResp> getAll(int page, int size, SortType sortType) {
        if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        return this.questionRepository.findAll(pagination)
                .map(this::entityToResp);
    }

    private Question requestToEntity(QuestionReq request) {
        // Buscar el Quiz por su id
        Quiz quiz = quizRepository.findById(request.getQuiz())
                .orElseThrow(() -> new RuntimeException("Quiz no encontrado"));

        // Crear la entidad Question y asignar los valores
        Question question = new Question();
        question.setQuiz(quiz); // Ahora asignamos el objeto Quiz obtenido
        question.setQuestion(request.getQuestion());
        question.setAnswers(request.getAnswers());
        return question;
    }

    private QuestionResp entityToResp(Question entity) {
        QuestionResp resp = new QuestionResp();
        resp.setIdQuestion(entity.getIdQuestion());
        resp.setQuiz(entity.getQuiz());
        resp.setQuestion(entity.getQuestion());
        resp.setAnswers(entity.getAnswers());
        return resp;
    }

    private Question find(Integer id) {
        return this.questionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("No hay citas con el id suministrado"));
    }

    public List<Question> getQuestionsByIdQuiz(Long idQuiz) {
        return questionRepository.findByQuizId(idQuiz); // Método que busca las preguntas por quizId
    }

}
