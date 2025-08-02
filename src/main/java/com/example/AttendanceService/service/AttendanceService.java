package com.example.AttendanceService.service;

import com.example.AttendanceService.entity.AttendanceRecord;
import com.example.AttendanceService.repository.AttendanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRecordRepository attendanceRepository;

    public String submitAttendance(List<AttendanceRecord> records) {
        attendanceRepository.saveAll(records);
        return "Attendance submitted successfully!";
    }

    public List<AttendanceRecord> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public void deleteAllAttendance() {
        attendanceRepository.deleteAll();
    }
}
