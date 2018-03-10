package com.xl.devops.service;

import com.xl.devops.domain.Student;
import com.xl.devops.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> fetchAll(){
        return (List<Student>) studentRepository.findAll();
    }

    public Student add(Student student){
        return studentRepository.save(student);
    }

    public Student findById(Long id){
        return studentRepository.findOne(id);
    }

    public Student createNewStudentWithStudentId(Long StudentId){
        return new Student(StudentId);
    }
}
