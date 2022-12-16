package com.peaksoft.restapipractice.service;

import com.peaksoft.restapipractice.dto.lesson.LessonRequest;
import com.peaksoft.restapipractice.dto.lesson.LessonResponse;
import com.peaksoft.restapipractice.entity.Lesson;

import java.util.List;

public interface LessonService {

    List<LessonResponse> getAllLessons(Long id);

    LessonResponse addLesson(Long id, LessonRequest lessonRequest);

    LessonResponse getLessonById(Long id);

    LessonResponse updateLesson(LessonRequest lessonRequest, Long id);

    LessonResponse deleteLesson(Long id);
}

