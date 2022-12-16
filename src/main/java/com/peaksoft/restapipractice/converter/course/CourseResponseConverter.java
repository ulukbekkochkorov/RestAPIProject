package com.peaksoft.restapipractice.converter.course;

import com.peaksoft.restapipractice.dto.course.CourseResponse;
import com.peaksoft.restapipractice.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseResponseConverter {
    public CourseResponse viewCourse(Course course){
        if (course==null){
            return null;
        }

        CourseResponse courseResponse = new CourseResponse();

        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getName());
        courseResponse.setDuration(course.getDuration());
        courseResponse.setDescription(course.getDescription());

        return courseResponse;
    }

    public List<CourseResponse> view(List<Course> courses){
        List<CourseResponse> courseResponses = new ArrayList<>();

        for (Course course: courses) {
            courseResponses.add(viewCourse(course));
        }

        return  courseResponses;
    }
}
