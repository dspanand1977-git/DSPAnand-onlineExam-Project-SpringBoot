//package com.exam.onlineexam.controller;
//
//import com.exam.onlineexam.model.Result;
//import com.exam.onlineexam.service.ResultService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class ResultController {
//
//    @Autowired
//    private ResultService resultService;
//
//    @PostMapping("/submitExam")
//    public String submitExam(@RequestParam Long studentId,
//                             @RequestParam Long examId,
//                             @RequestParam int score, Model model) {
//
//        // Save result
//        Result result = new Result();
//        result.setStudentId(studentId);
//        result.setExamId(examId);
//        result.setScore(score);
//        resultService.saveResult(result);
//
//        model.addAttribute("score", score);
//
//        return "result";
//    }
//}


//************************************************************

package com.exam.onlineexam.controller;

import com.exam.onlineexam.model.Question;
import com.exam.onlineexam.model.Result;
import com.exam.onlineexam.service.QuestionService;
import com.exam.onlineexam.service.ResultService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;   // ✅ ADDED

@Controller
public class ResultController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private QuestionService questionService;  // ✅ ADDED

    @PostMapping("/submitExam")
    public String submitExam(@RequestParam Long studentId,
                             @RequestParam Long examId,
                             @RequestParam Map<String,String> answers,  // ✅ CHANGED
                             Model model) {

        //*****************

        List<Question> questions = questionService.getQuestionsByExam(examId);

        int score = 0;

        for (Question q : questions) {

            String selected = answers.get(String.valueOf(q.getId()));  // get answer for this question

            if(selected != null && selected.trim().equalsIgnoreCase(q.getCorrectAnswer().trim())) {
                score++;
            }
        }


        //***************

        // ✅ SIMPLE SCORE LOGIC (TEMP)

        Result result = new Result();
        result.setStudentId(studentId);
        result.setExamId(examId);
        result.setScore(score);

        resultService.saveResult(result);

        model.addAttribute("score", score);

        return "result";
    }
}