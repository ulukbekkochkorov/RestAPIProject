package com.peaksoft.restapipractice.service;
import com.peaksoft.restapipractice.dto.instructor.InstructorRequest;
import com.peaksoft.restapipractice.dto.instructor.InstructorResponse;
import com.peaksoft.restapipractice.entity.Instructor;

import java.io.IOException;
import java.util.List;

public interface InstructorService {

    List<InstructorResponse> listAllInstructors();
    List<InstructorResponse> getAllInstructors(Long courseId);

    InstructorResponse addInstructor(Long id,InstructorRequest instructorRequest);

    InstructorResponse getInstructorById(Long id);

    InstructorResponse updateInstructor(InstructorRequest instructorRequest, Long id);

    InstructorResponse deleteInstructor(Long id);

    void assignInstructor(Long courseId,Long instructorId) throws IOException;
}

