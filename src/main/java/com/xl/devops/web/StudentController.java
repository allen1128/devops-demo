package com.xl.devops.web;

import com.xl.devops.domain.Student;
import com.xl.devops.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    public List<Student> getStudents() {
        List<Student> students = studentService.fetchAll();
        logger.info("all students fetched {}", students);
        return students;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        logger.info("student {} is to be added", student);
        return studentService.add(student);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces = "application/json")
    public Student getStudent(@PathVariable Long id) {

        return studentService.findById(id);
    }
}
