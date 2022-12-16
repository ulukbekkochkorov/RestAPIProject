package com.peaksoft.restapipractice.service.impl;

import com.peaksoft.restapipractice.converter.course.CourseRequestConverter;
import com.peaksoft.restapipractice.converter.course.CourseResponseConverter;
import com.peaksoft.restapipractice.dto.course.CourseRequest;
import com.peaksoft.restapipractice.dto.course.CourseResponse;
import com.peaksoft.restapipractice.entity.Company;
import com.peaksoft.restapipractice.entity.Course;
import com.peaksoft.restapipractice.repository.CompanyRepository;
import com.peaksoft.restapipractice.repository.CourseRepository;
import com.peaksoft.restapipractice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final CourseRequestConverter courseRequestConverter;
    private final CourseResponseConverter courseResponseConverter;

    @Override
    public List<CourseResponse> getAllCourses(Long id) {
        return courseResponseConverter.view(courseRepository.getAllCourses(id));
    }

    @Override
    public CourseResponse addCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRequestConverter.createCourse(courseRequest);
        Company company = companyRepository.getById(id);
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id).get();
        courseRequestConverter.updateCourse(course, courseRequest);
        courseRepository.save(course);

        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse deleteCourse(Long id) {
        Course course = courseRepository.findById(id).get();
        courseRepository.delete(course);
        return courseResponseConverter.viewCourse(course);
    }

}
