package com.example.AttendanceService.service;

import com.example.AttendanceService.entity.ClassSchedule;
import com.example.AttendanceService.repository.ClassScheduleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        List<ClassSchedule> sampleSchedules = new ArrayList<>();

        String[] courseCodes = { "21PD20", "21PD21", "21PD22", "21PD23", "21PD24" };
        String[] courseNames = { "Data Structures", "Operating Systems", "Computer Networks", "Software Engineering", "Database Systems" };
        String[] batches = { "2026", "2027", "2028", "2029" };

        Random random = new Random();
        int idCounter = 1;

        for (int day = 1; day <= 31; day++) {
            LocalDate date = LocalDate.of(2025, 8, day);
            DayOfWeek dow = date.getDayOfWeek();
            String dayOfWeek = dow.toString().substring(0, 1) + dow.toString().substring(1).toLowerCase();

            for (int i = 0; i < 5; i++) {
                String id = String.format("CL%03d", idCounter++);
                String batch = batches[random.nextInt(batches.length)];
                String courseCode = courseCodes[i];
                String courseName = courseNames[i];
                int hour = i + 1;

                sampleSchedules.add(new ClassSchedule(
                        id,
                        batch,
                        courseCode,
                        courseName,
                        hour,
                        dayOfWeek,
                        date
                ));
            }
        }

        repository.saveAll(sampleSchedules);
        System.out.println("✅ Auto-generated class schedules inserted (Aug 2025).");
    }
}
