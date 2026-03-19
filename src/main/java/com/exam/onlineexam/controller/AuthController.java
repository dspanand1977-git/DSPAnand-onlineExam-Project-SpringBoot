package com.exam.onlineexam.controller;

import com.exam.onlineexam.model.Student;
import com.exam.onlineexam.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Student student, HttpSession session) {

            Student s = studentService.login(student.getEmail(), student.getPassword());

            if (s != null) {
                session.setAttribute("student", s);
                return "redirect:/dashboard";
            }
            return "login";


    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(Student student) {

        studentService.register(student);
        return "redirect:/login";
    }

        @GetMapping("/logout")
        public String logout(HttpSession session) {
            session.invalidate();
            return "redirect:/login";
        }
}
