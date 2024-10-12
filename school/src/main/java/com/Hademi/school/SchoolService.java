package com.Hademi.school;

import com.Hademi.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    public SchoolService(SchoolRepository repository, StudentClient client) {
        this.repository = repository;
        this.client = client;
    }

    public void saveSchool(School school){
        repository.save(school);
    }
    public List<School> findAllSchools(){
        return repository.findAll();
    }
    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {

        var school = repository.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School not found"));

        var students = client.findAllStudentsBySchool(schoolId);

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();  // This closes the builder pattern.
    }
}

