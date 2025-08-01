package com.example.AttendanceService.dto;

import com.example.AttendanceService.entity.ClassSchedule;
import com.example.AttendanceService.entity.Student;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRequest {
    private Filters filters;
    private List<ClassSchedule> selectedClasses;
    private List<Student> students;
    private List<AttendanceDTO> attendanceData;

    @Data
    public static class Filters {
        private LocalDate date;
        private String batch;
        private String courseCode;
    }

    @Data
    public static class AttendanceDTO {
        private String classId;
        private String studentId;
        private String status;
    }
}

