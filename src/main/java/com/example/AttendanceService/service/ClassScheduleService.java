package com.example.AttendanceService.service;

import com.example.AttendanceService.entity.ClassSchedule;
import com.example.AttendanceService.repository.ClassScheduleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClassScheduleService {

    @Autowired
    private ClassScheduleRepository repository;

    public List<ClassSchedule> getByDate(LocalDate date) {
        return repository.findByDate(date);
    }

    public List<String> getBatchesByDate(LocalDate date) {
        List<ClassSchedule> schedules = repository.findByDate(date);
        return schedules.stream()
                .map(ClassSchedule::getBatch)
                .distinct()
                .toList();
    }

    @PostConstruct
    public void forceInsertSampleData() {
        repository.deleteAll(); // Clear existing data

        List<ClassSchedule> sampleSchedules = List.of(
                new ClassSchedule("CL001", "2025", "CS101", "Data Structures", 1, "Monday", LocalDate.of(2025, 7, 27)),
                new ClassSchedule("CL002", "2026", "CS101", "Data Structures", 2, "Monday", LocalDate.of(2025, 7, 27)),
                new ClassSchedule("CL003", "2027", "EC202", "Digital Circuits", 3, "Monday", LocalDate.of(2025, 7, 27)),
                new ClassSchedule("CL004", "2028", "CS101", "Data Structures", 1, "Tuesday", LocalDate.of(2025, 7, 28)),
                new ClassSchedule("CL005", "2029", "CS101", "Data Structures", 2, "Tuesday", LocalDate.of(2025, 8, 1))
        );
        repository.saveAll(sampleSchedules);
        System.out.println("✅ All sample class schedules force-inserted.");
    }

}
