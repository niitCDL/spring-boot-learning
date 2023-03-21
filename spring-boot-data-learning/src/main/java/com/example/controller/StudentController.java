package com.example.controller;

import com.example.domain.Student;
import com.example.mapper.StudentMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Resource
    public StudentMapper studentMapper;

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id")Integer id){
        Student student = studentMapper.getSelectedCourses(id);
        return student;
    }


}
