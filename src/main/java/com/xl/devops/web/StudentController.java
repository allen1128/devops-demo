package com.xl.devops.web;

import com.xl.devops.domain.Student;
import com.xl.devops.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    public List<Student> getStudents() {
        List<Student> results = studentService.fetchAll();
        return results;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public Student addStudent(@RequestBody Student student) {
        return studentService.add(student);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = "application/json")
    public Student getStudent(@PathVariable Long id) {
        return studentService.findById(id);
    }
}
