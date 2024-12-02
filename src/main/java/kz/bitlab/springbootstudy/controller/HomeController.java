package kz.bitlab.springbootstudy.controller;

import kz.bitlab.springbootstudy.db.DBManager;
import kz.bitlab.springbootstudy.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model) {
        List<Student> students = DBManager.getStudents();
        model.addAttribute("studentter", students);
        return "home";
    }

    @GetMapping("/addstudent.html")
    public String showAddStudentPage() {
        return "addstudent";
    }
    @PostMapping("/addstudent")
    public String addStudent(@RequestParam(name = "student_name") String name,
                             @RequestParam(name = "student_surname") String surname,
                             @RequestParam(name = "student_exam") int exam,
                             @RequestParam(name = "student_mark") String mark) {

        Student newStudent = new Student(null, name, surname, exam, mark);
        DBManager.addStudent(newStudent);
        return "redirect:/";
    }
}
