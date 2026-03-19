package com.exam.onlineexam.controller;

import com.exam.onlineexam.model.Exam;
import com.exam.onlineexam.model.Question;
import com.exam.onlineexam.service.ExamService;
import com.exam.onlineexam.service.QuestionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ExamService examService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/login")
    public String adminLoginPage() {
        return "admin-login";
    }

    @PostMapping("/login")
    public String adminLoginSubmit(@RequestParam String password, HttpSession session) {
        if ("Anand@CKS".equals(password)) {
            session.setAttribute("admin", true);
            return "redirect:/admin";
        }
        return "redirect:/admin/login?error=true";
    }

    @GetMapping
    public String adminDashboard(Model model, HttpSession session) {
        if(session.getAttribute("admin") == null) return "redirect:/admin/login";
        List<Exam> exams = examService.getAllExams();
        model.addAttribute("exams", exams);
        return "admin-dashboard";
    }

    @GetMapping("/createExam")
    public String createExamPage(HttpSession session) {
        if(session.getAttribute("admin") == null) return "redirect:/admin/login";
        return "create-exam";
    }

    @PostMapping("/createExam")
    public String createExam(Exam exam, HttpSession session) {
        if(session.getAttribute("admin") == null) return "redirect:/admin/login";
        examService.createExam(exam);
        return "redirect:/admin";
    }

    @GetMapping("/addQuestion/{examId}")
    public String addQuestionPage(@PathVariable Long examId, Model model, HttpSession session) {
        if(session.getAttribute("admin") == null) return "redirect:/admin/login";
        model.addAttribute("examId", examId);
        return "add-question";
    }

    @PostMapping("/addQuestion")
    public String addQuestion(Question question, @RequestParam Long examId, HttpSession session) {
        if(session.getAttribute("admin") == null) return "redirect:/admin/login";
        Exam exam = examService.getExam(examId);
        question.setExam(exam);
        questionService.addQuestion(question);
        return "redirect:/admin";
    }
}
