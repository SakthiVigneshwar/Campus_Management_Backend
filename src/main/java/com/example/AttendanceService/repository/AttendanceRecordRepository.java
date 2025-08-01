package com.example.AttendanceService.repository;

import com.example.AttendanceService.entity.AttendanceRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRecordRepository extends MongoRepository<AttendanceRecord, String> {
}
