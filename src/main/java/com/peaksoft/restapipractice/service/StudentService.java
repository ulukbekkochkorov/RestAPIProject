package com.peaksoft.restapipractice.service;
import com.peaksoft.restapipractice.dto.student.StudentRequest;
import com.peaksoft.restapipractice.dto.student.StudentResponse;
import com.peaksoft.restapipractice.entity.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<StudentResponse> getStudentList();

    List<StudentResponse> getAllStudents(Long groupId);

    StudentResponse addStudent(Long id, StudentRequest studentRequest) throws IOException;

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(StudentRequest studentRequest, Long id) throws IOException;

    StudentResponse deleteStudent(Long id);

    void assignStudent(Long groupId,Long studentId) throws IOException;
}
