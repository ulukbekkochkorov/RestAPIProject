package com.peaksoft.restapipractice.service.impl;
import com.peaksoft.restapipractice.converter.instructor.InstructorRequestConverter;
import com.peaksoft.restapipractice.converter.instructor.InstructorResponseConverter;
import com.peaksoft.restapipractice.dto.instructor.InstructorRequest;
import com.peaksoft.restapipractice.dto.instructor.InstructorResponse;
import com.peaksoft.restapipractice.entity.Company;
import com.peaksoft.restapipractice.entity.Course;
import com.peaksoft.restapipractice.entity.Group;
import com.peaksoft.restapipractice.entity.Instructor;
import com.peaksoft.restapipractice.repository.CourseRepository;
import com.peaksoft.restapipractice.repository.InstructorRepository;
import com.peaksoft.restapipractice.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final InstructorRequestConverter instructorRequestConverter;
    private final InstructorResponseConverter instructorResponseConverter;


    @Override
    public List<InstructorResponse> listAllInstructors() {
        return instructorResponseConverter.view(instructorRepository.findAll());
    }

    @Override
    public List<InstructorResponse> getAllInstructors(Long courseId) {
        return instructorResponseConverter.view(instructorRepository.getReferenceById(courseId).getCourse().getInstructorsList());
    }

    @Override
    public InstructorResponse addInstructor(Long id, InstructorRequest instructorRequest) {
        Course course1 = courseRepository.getById(id);
        Instructor instructor = instructorRepository.getReferenceById(id);
        course1.addInstructor(instructor);
        instructor.setCourse(course1);
        instructorRepository.save(instructor);
        return instructorResponseConverter.viewInstructor(instructor);
    }

    @Override
    public InstructorResponse getInstructorById(Long id) {
        Instructor instructor = instructorRepository.getById(id);
        return instructorResponseConverter.viewInstructor(instructor);
    }

    @Override
    public InstructorResponse updateInstructor(InstructorRequest instructorRequest, Long id) {
        Instructor instructor = instructorRepository.getById(id);
        instructorRequestConverter.updateInstructor(instructor,instructorRequest);
        instructorRepository.save(instructor);
        return instructorResponseConverter.viewInstructor(instructor);
    }

    @Override
    public InstructorResponse deleteInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id).get();
        instructorRepository.delete(instructor);
        return instructorResponseConverter.viewInstructor(instructor);
    }

    @Override
    public void assignInstructor(Long courseId, Long instructorId) throws IOException {
Instructor instructor = instructorRepository.findById(instructorId).get();
Course course = courseRepository.findById(courseId).get();
if (course.getInstructorsList()!=null){
    for (Instructor g : course.getInstructorsList()){
        if (g.getId()==instructorId){
            throw new IOException("This instructor already exists!");
        }
    }
}
instructor.getCourse().getInstructorsList().remove(instructor);
instructor.setCourse(course);
course.addInstructor(instructor);
instructorRepository.save(instructor);
courseRepository.save(course);
    }
}
