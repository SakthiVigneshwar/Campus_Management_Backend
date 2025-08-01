package com.example.AttendanceService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "attendance")
public class AttendanceRecord {
    @Id
    private String id;

    private String classId;          // Refers to ClassSchedule.id
    private String studentId;
    private String status;           // Present / Absent / Leave
    private LocalDate date;



}

