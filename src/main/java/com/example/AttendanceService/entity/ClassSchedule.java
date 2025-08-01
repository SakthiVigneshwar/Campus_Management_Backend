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
@Document(collection = "class_schedules")
public class ClassSchedule {
    @Id
    private String id;

    private String batch;        // e.g., CSE-A
    private String courseCode;   // e.g., CS101
    private String courseName;   // e.g., Data Structures
    private int hour;            // Hour slot
    private String day;          // Monday, Tuesday, etc.
    private LocalDate date;      // Actual date (yyyy-MM-dd)



}
