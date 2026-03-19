package com.exam.onlineexam.service;

import com.exam.onlineexam.model.Student;
import com.exam.onlineexam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public Student register(Student student){

        return studentRepo.save(student);
    }

    public  Student login(String email, String password){

        Student student = studentRepo.findByEmail(email);

        if(student != null && student.getPassword().equals(password)){
            return student;
        }

        return null;

    }
}
