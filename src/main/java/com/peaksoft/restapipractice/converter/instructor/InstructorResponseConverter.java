package com.peaksoft.restapipractice.converter.instructor;

import com.peaksoft.restapipractice.dto.instructor.InstructorResponse;
import com.peaksoft.restapipractice.entity.Instructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InstructorResponseConverter {
    public InstructorResponse viewInstructor(Instructor instructor) {
        if (instructor == null) {
            return null;
        }
        InstructorResponse instructorResponse = new InstructorResponse();

        instructorResponse.setId(instructor.getId());
        instructorResponse.setLastName(instructor.getLastName());
        instructorResponse.setFirstName(instructor.getFirstName());
        instructorResponse.setPhoneNumber(instructor.getPhoneNumber());
        instructorResponse.setEmail(instructor.getEmail());
        instructorResponse.setSpecialization(instructor.getSpecialization());
        return instructorResponse;
    }
    public List<InstructorResponse> view(List<Instructor> instructors) {
        List<InstructorResponse> instructorResponseList = new ArrayList<>();
        for (Instructor instructor : instructors) {
            instructorResponseList.add(viewInstructor(instructor));
        }
        return instructorResponseList;
    }

}
