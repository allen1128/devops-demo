package com.xl.devops.web;

import com.xl.devops.domain.Student;
import com.xl.devops.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@Controller
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    public List<Student> getStudents() {
        List<Student> results = studentService.fetchAll();
        return results;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ResponseBody
    public Student addStudent(@RequestBody Student student) {
        return studentService.add(student);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces = "application/json")
    public Student getStudent(@PathVariable Long id) {
        return studentService.findById(id);
    }
}
