package com.xl.devops.service;

import com.xl.devops.domain.Student;
import com.xl.devops.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> fetchAll(){
        return (List<Student>) studentRepository.findAll();
    }

    public Student add(Student student){
        Student student1 = studentRepository.save(student);
        return student1;
    }

    public Student findById(Long id){
        return studentRepository.findOne(id);
    }

    public Student createNewStudentWithStudentId(Long StudentId){
        return new Student(StudentId);
    }
}
