package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository repository;

    @RequestMapping(value = { "/", "/studentlist" })
    public String studentList(Model model) {
        model.addAttribute("students", repository.findAll());
        return "studentlist";
    }

    @RequestMapping(value = { "/delete" })
    public String studentListDelete(Model model) {
        repository.deleteAll();
        Student mihail = new Student("Mihail", "Testi1", "Test3");
        repository.save(mihail);

        model.addAttribute("students", repository.findAll());
        return "studentlist";
    }

}
