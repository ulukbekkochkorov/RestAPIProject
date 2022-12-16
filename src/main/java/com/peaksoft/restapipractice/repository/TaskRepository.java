package com.peaksoft.restapipractice.repository;
import com.peaksoft.restapipractice.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task t where t.lesson.id = :lessonId")
    List<Task> findAllTaskByLessonId(Long lessonId);
}
