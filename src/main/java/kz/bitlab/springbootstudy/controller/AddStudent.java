package kz.bitlab.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddStudent {
    @GetMapping("/addstudet")
    public String addStudent() {
        return "addstudent";
    }
}
