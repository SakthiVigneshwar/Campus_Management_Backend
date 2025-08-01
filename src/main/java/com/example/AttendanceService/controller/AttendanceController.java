package com.example.AttendanceService.controller;

import com.example.AttendanceService.dto.AttendanceRequest;
import com.example.AttendanceService.entity.AttendanceRecord;
import com.example.AttendanceService.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitAttendance(@RequestBody AttendanceRequest request) {
        List<AttendanceRecord> records = request.getAttendanceData().stream().map(a -> {
            AttendanceRecord record = new AttendanceRecord();
            record.setClassId(a.getClassId());
            record.setStudentId(a.getStudentId());
            record.setStatus(a.getStatus());
            record.setDate(request.getFilters().getDate());
            return record;
        }).toList();

        return ResponseEntity.ok(attendanceService.submitAttendance(records));
    }
}

