package com.peaksoft.restapipractice.converter.lesson;

import com.peaksoft.restapipractice.dto.lesson.LessonResponse;
import com.peaksoft.restapipractice.entity.Lesson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LessonResponseConverter {
    public LessonResponse viewLesson(Lesson lesson){
        if (lesson==null){
            return null;
        }
        LessonResponse lessonResponse = new LessonResponse();
        lessonResponse.setId(lesson.getId());
        lessonResponse.setLessonName(lesson.getLessonName());
        return lessonResponse;
    }

    public List<LessonResponse> view(List<Lesson> lessons){
        List<LessonResponse> lessonResponses = new ArrayList<>();

        for (Lesson lesson: lessons){
            lessonResponses.add(viewLesson(lesson));
        }
        return lessonResponses;
    }
}
