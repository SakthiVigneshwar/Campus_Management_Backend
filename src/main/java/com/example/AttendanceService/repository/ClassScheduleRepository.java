package com.example.AttendanceService.repository;

import com.example.AttendanceService.entity.ClassSchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClassScheduleRepository extends MongoRepository<ClassSchedule, String> {
    List<ClassSchedule> findByDate(LocalDate date);
    List<ClassSchedule> findByDateAndBatchAndCourseCode(LocalDate date, String batch, String courseCode);
}

