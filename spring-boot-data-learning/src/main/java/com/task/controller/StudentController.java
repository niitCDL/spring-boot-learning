package com.task.controller;

import com.task.domain.Student;
import com.task.mapper.StudentMapper;
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
