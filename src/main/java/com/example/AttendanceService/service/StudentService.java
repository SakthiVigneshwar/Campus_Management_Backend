package com.example.AttendanceService.service;

import com.example.AttendanceService.entity.Student;
import com.example.AttendanceService.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public List<Student> getByBatch(String batch) {
        return studentRepo.findByBatch(batch);
    }

    @PostConstruct
    public void loadDummyStudents() {
        studentRepo.deleteAll();

        List<Student> students = Arrays.asList(
                new Student("25CS001", "Arun Kumar", "2025"),
                new Student("25CS002", "Bhuvana", "2025"),
                new Student("26CS003", "Chandru", "2026"),
                new Student("26CS004", "Deepika", "2026"),
                new Student("27EC005", "Eshwar", "2027"),
                new Student("27EC006", "Fathima", "2027"),
                new Student("28CS007", "Gokul Raj", "2028"),
                new Student("28CS008", "Harshini", "2028"),
                new Student("29CS009", "Ilango", "2029"),
                new Student("29CS010", "Jeyashree", "2029")
        );

        studentRepo.saveAll(students);
        System.out.println("✅ Dummy students inserted successfully.");
    }
}
