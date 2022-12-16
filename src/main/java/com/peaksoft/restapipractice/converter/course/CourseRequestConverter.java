package com.peaksoft.restapipractice.converter.course;

import com.peaksoft.restapipractice.dto.course.CourseRequest;
import com.peaksoft.restapipractice.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseRequestConverter {
    public Course createCourse(CourseRequest courseRequest){
        if (courseRequest == null){
            return null;
        }

        Course course = new Course();

        course.setName(courseRequest.getCourseName());
        course.setDescription(courseRequest.getDescription());
        course.setDuration(courseRequest.getDuration());

        return course;
    }


    public void updateCourse(Course course, CourseRequest courseRequest){
        if (courseRequest.getCourseName() != null){
            course.setName(courseRequest.getCourseName());
        }if (courseRequest.getDuration() !=null){
            course.setDuration(courseRequest.getDuration());
        }if (courseRequest.getDescription() != null){
            course.setDescription(courseRequest.getDescription());
        }
    }
}
