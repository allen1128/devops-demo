package com.xl.devops.service;

import com.xl.devops.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class StudentServiceTest {
    @Test
    public void createNewStudentWithStudentId() throws Exception {
        StudentService studentService = new StudentService();
        Student student = studentService.createNewStudentWithStudentId(1l);
        assertTrue(student.getStudentId().equals(1l));
    }
}