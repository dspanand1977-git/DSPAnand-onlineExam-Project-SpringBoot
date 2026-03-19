package com.exam.onlineexam.controller;


import com.exam.onlineexam.model.Question;
import com.exam.onlineexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/addQuestion")
    public String addQuestion(Question question) {

        questionService.addQuestion(question);
        return "redirect:/dashboard";
    }
}
