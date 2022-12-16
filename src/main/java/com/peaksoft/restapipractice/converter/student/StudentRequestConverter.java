package com.peaksoft.restapipractice.converter.student;

import com.peaksoft.restapipractice.dto.student.StudentRequest;
import com.peaksoft.restapipractice.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRequestConverter {
    public Student createStudent(StudentRequest studentRequest) {
        if (studentRequest == null) {
            return null;
        }
        Student student = new Student();

        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());

        return student;
    }
    public void updateStudent(Student student, StudentRequest studentRequest){
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
    }
}
