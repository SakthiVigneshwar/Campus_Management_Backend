    package com.example.AttendanceService.repository;

    import com.example.AttendanceService.entity.AttendanceRecord;
    import org.springframework.data.mongodb.repository.MongoRepository;

    public interface AttendanceRecordRepository extends MongoRepository<AttendanceRecord, String> {
    }
