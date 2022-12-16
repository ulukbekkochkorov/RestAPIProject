package com.peaksoft.restapipractice.converter.lesson;

import com.peaksoft.restapipractice.dto.lesson.LessonRequest;
import com.peaksoft.restapipractice.dto.lesson.LessonResponse;
import com.peaksoft.restapipractice.entity.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonRequestConverter {
    public Lesson createLesson(LessonRequest lessonRequest){
        if (lessonRequest == null){
            return null;
        }
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        return lesson;

    }
    public void updateLesson(Lesson lesson, LessonRequest lessonRequest){
        if (lessonRequest.getLessonName() != null){
            lesson.setLessonName(lessonRequest.getLessonName());
        }
    }
}
