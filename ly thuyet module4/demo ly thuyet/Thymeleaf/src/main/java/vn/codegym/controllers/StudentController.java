package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.services.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService ;

    @GetMapping(value = {"","/list"})
    public ModelAndView studentList(){
        return new ModelAndView("/student/list", "studentList", studentService.findAll());
    }


    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());

        List<String> languageList = new ArrayList<>();
        languageList.add("C#");
        languageList.add("JAVA");
        languageList.add("PHP");
        languageList.add("ZZZZ");
        model.addAttribute("languageList", languageList);
        return "/student/create";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes) {
        studentService.save(student);
        redirectAttributes.addFlashAttribute("successMsg", "Create student: "+student.getName() +" success!");
        return "redirect:/student";
//        return "forward:/student";
    }
//
    @GetMapping(value = "/edit/{id}")
    public String showEditPage(@PathVariable int id, Model model){

        model.addAttribute("student", studentService.findById(id));

        List<String> languageList = new ArrayList<>();
        languageList.add("C#");
        languageList.add("JAVA");
        languageList.add("PHP");
        languageList.add("ZZZZ");
        model.addAttribute("languageList", languageList);

        return "/student/edit";
    }

    @PostMapping(value = "/edit")
    public String editStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes){
        studentService.save(student);
        redirectAttributes.addFlashAttribute("successMsg", "Update student: "+student.getName() +" success!");
        return "redirect:/student";
    }
}
