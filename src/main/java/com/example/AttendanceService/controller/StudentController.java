package com.example.AttendanceService.controller;

import com.example.AttendanceService.entity.Student;
import com.example.AttendanceService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/attendance")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public List<Student> getStudents(
            @RequestParam("batch") String batch,
            @RequestParam("courseCode") String courseCode) {
        // Course code is not needed if batch alone identifies the students.
        return studentService.getByBatch(batch);
    }
}

