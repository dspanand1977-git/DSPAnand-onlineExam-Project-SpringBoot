package com.exam.onlineexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.onlineexam.model.Result;

import java.util.List;


public interface ResultRepository extends JpaRepository<Result,Long> {

    List<Result> findByStudentId(Long studentId);


}
