package com.exam.onlineexam.service;


import com.exam.onlineexam.model.Question;
import com.exam.onlineexam.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepo;

    public Question addQuestion(Question question){
        return questionRepo.save(question);
    }

    public List<Question> getQuestionsByExam(Long examId){
        return questionRepo.findByExamId(examId);
    }
}
