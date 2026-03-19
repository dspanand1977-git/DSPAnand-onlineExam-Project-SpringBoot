package com.exam.onlineexam.service;

import com.exam.onlineexam.model.Exam;
import com.exam.onlineexam.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepo;

    public Exam createExam(Exam exam){

        return examRepo.save(exam);
    }

    public List<Exam> getAllExams(){
        return examRepo.findAll();
    }

    public Exam getExam(Long id){
        return examRepo.findById(id).orElse(null);
    }
}


