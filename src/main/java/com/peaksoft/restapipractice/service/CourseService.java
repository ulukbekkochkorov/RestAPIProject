package com.peaksoft.restapipractice.service;
import com.peaksoft.restapipractice.dto.course.CourseRequest;
import com.peaksoft.restapipractice.dto.course.CourseResponse;
import com.peaksoft.restapipractice.entity.Course;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses(Long id);

    CourseResponse addCourse(Long id, CourseRequest courseRequest);

    CourseResponse getCourseById(Long id);

    CourseResponse updateCourse(Long courseId, CourseRequest courseRequest);

    CourseResponse deleteCourse(Long id);
}
