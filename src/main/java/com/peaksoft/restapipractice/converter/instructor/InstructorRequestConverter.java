package com.peaksoft.restapipractice.converter.instructor;

import com.peaksoft.restapipractice.dto.instructor.InstructorRequest;
import com.peaksoft.restapipractice.dto.instructor.InstructorResponse;
import com.peaksoft.restapipractice.entity.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorRequestConverter {
    public Instructor createInstructor(InstructorRequest instructorRequest) {
        if (instructorRequest == null) {
            return null;
        }
        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setEmail(instructorRequest.getEmail());

        return instructor;
    }
    public void updateInstructor(Instructor instructor, InstructorRequest instructorRequest) {
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setEmail(instructorRequest.getEmail());

    }

}
