package com.example.AttendanceService.service;

import com.example.AttendanceService.entity.AttendanceRecord;
import com.example.AttendanceService.repository.AttendanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRecordRepository attendanceRepo;

    public String submitAttendance(List<AttendanceRecord> records) {
        attendanceRepo.saveAll(records);
        return "Attendance Submitted Successfully";
    }
}

