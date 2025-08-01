package com.example.AttendanceService.controller;

import com.example.AttendanceService.entity.ClassSchedule;
import com.example.AttendanceService.repository.ClassScheduleRepository;
import com.example.AttendanceService.service.ClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/attendance/classes")
public class ClassScheduleController {

    @Autowired
    private ClassScheduleService classService;

    @Autowired
    private ClassScheduleRepository classScheduleRepository; // ✅ FIXED

    @GetMapping("/by-date")
    public List<ClassSchedule> getClassesByDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return classService.getByDate(date);
    }

    @GetMapping("/batches")
    public List<String> getBatchesByDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return classService.getBatchesByDate(date);
    }

    @GetMapping("/hour")
    public List<ClassSchedule> getHoursByDateBatchAndCourse(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam String batch,
            @RequestParam String courseCode) {
        return classScheduleRepository.findByDateAndBatchAndCourseCode(date, batch, courseCode);
    }
}
    