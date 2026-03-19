//package com.exam.onlineexam.controller;
//
//import com.exam.onlineexam.model.Exam;
//import com.exam.onlineexam.model.Question;
//import com.exam.onlineexam.service.ExamService;
//import com.exam.onlineexam.service.QuestionService;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@Controller
//public class ExamController {
//
//    @Autowired
//    private ExamService examService;
//
//    @Autowired
//    private QuestionService questionService;
//
//    @GetMapping("/dashboard")
//    public String dashboard(Model model, HttpSession session) {
//
//        if(session.getAttribute("student") == null){
//            return "redirect:/login";
//        }
//
//        List<Exam> exams = examService.getAllExams();
//        model.addAttribute("exams", exams);
//
//        return "dashboard";
//    }
//
//    @GetMapping("/exam/{id}")
//    public String startExam(@PathVariable Long id, Model model) {
//
//        List<Question> questions  = questionService.getQuestionsByExam(id);
//        model.addAttribute("questions", questions);
//        return "exam";
//    }
//}


//*********************************************************

package com.exam.onlineexam.controller;

import com.exam.onlineexam.model.Exam;
import com.exam.onlineexam.model.Question;
import com.exam.onlineexam.model.Student;   // ✅ ADDED
import com.exam.onlineexam.service.ExamService;
import com.exam.onlineexam.service.QuestionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        if(session.getAttribute("student") == null){
            return "redirect:/login";
        }

        List<Exam> exams = examService.getAllExams();
        model.addAttribute("exams", exams);

        return "dashboard";
    }

    @GetMapping("/exam/{id}")
    public String startExam(@PathVariable Long id,
                            Model model,
                            HttpSession session) {   // ✅ ADDED

        // ✅ ADDED (GET STUDENT FROM SESSION)
        Student student = (Student) session.getAttribute("student");

        if(student == null){
            return "redirect:/login";
        }

        List<Question> questions  = questionService.getQuestionsByExam(id);

        model.addAttribute("questions", questions);
        model.addAttribute("student", student);   // ✅ ADDED
        model.addAttribute("examId", id);         // ✅ ADDED

        return "exam";
    }
}