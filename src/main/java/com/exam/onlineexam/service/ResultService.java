package com.exam.onlineexam.service;

import com.exam.onlineexam.model.Result;
import com.exam.onlineexam.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepo;

    public Result saveResult(Result result){
        return resultRepo.save(result);
    }

    public List<Result> getResultsByStudent(Long studentId){
        return resultRepo.findByStudentId(studentId);
    }
}
