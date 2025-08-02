package com.example.AttendanceService.controller;

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
    public ResponseEntity<String> submitAttendance(@RequestBody List<AttendanceRecord> records) {
        return ResponseEntity.ok(attendanceService.submitAttendance(records));
    }

    @GetMapping("/history")
    public ResponseEntity<List<AttendanceRecord>> getAttendanceHistory() {
        return ResponseEntity.ok(attendanceService.getAllAttendance());
    }

    @DeleteMapping("/cleanup")
    public ResponseEntity<String> deleteAllAttendance() {
        attendanceService.deleteAllAttendance();
        return ResponseEntity.ok("All attendance records deleted successfully.");
    }
}
    