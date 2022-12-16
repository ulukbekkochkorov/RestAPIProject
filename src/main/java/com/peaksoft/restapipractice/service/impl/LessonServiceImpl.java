package com.peaksoft.restapipractice.service.impl;

import com.peaksoft.restapipractice.converter.lesson.LessonRequestConverter;
import com.peaksoft.restapipractice.converter.lesson.LessonResponseConverter;
import com.peaksoft.restapipractice.dto.lesson.LessonRequest;
import com.peaksoft.restapipractice.dto.lesson.LessonResponse;
import com.peaksoft.restapipractice.entity.Course;
import com.peaksoft.restapipractice.entity.Lesson;
import com.peaksoft.restapipractice.repository.CourseRepository;
import com.peaksoft.restapipractice.repository.LessonRepository;
import com.peaksoft.restapipractice.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;
    private final LessonRequestConverter lessonRequestConverter;
    private final LessonResponseConverter lessonResponseConverter;

    @Override
    public List<LessonResponse> getAllLessons(Long id) {
        return lessonResponseConverter.view(lessonRepository.findAllLessonByCourseId(id));
    }

    @Override
    public LessonResponse addLesson(Long id, LessonRequest lessonRequest) {
        Course course = courseRepository.getById(id);
        Lesson lesson = lessonRequestConverter.createLesson(lessonRequest);
        course.addLesson(lesson);
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        return lessonResponseConverter.viewLesson(lesson);

    }

    @Override
    public LessonResponse getLessonById(Long id) {

        return lessonResponseConverter.viewLesson(lessonRepository.getById(id));
    }

    @Override
    public LessonResponse updateLesson(LessonRequest lessonRequest, Long id) {
        Lesson lesson1 = lessonRepository.findById(id).get();
        lessonRequestConverter.updateLesson(lesson1,lessonRequest);
        lessonRepository.save(lesson1);
        return lessonResponseConverter.viewLesson(lesson1);

    }

    @Override
    public LessonResponse deleteLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id).get();
        lessonRepository.delete(lesson);
        return lessonResponseConverter.viewLesson(lesson);

    }
}
