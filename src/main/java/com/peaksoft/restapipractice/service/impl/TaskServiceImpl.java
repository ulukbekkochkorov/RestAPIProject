package com.peaksoft.restapipractice.service.impl;

import com.peaksoft.restapipractice.converter.task.TaskRequestConverter;
import com.peaksoft.restapipractice.converter.task.TaskResponseConverter;
import com.peaksoft.restapipractice.dto.task.TaskRequest;
import com.peaksoft.restapipractice.dto.task.TaskResponse;
import com.peaksoft.restapipractice.entity.Lesson;
import com.peaksoft.restapipractice.entity.Task;
import com.peaksoft.restapipractice.repository.LessonRepository;
import com.peaksoft.restapipractice.repository.TaskRepository;
import com.peaksoft.restapipractice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final LessonRepository lessonRepository;
    private final TaskRequestConverter taskRequestConverter;
    private final TaskResponseConverter taskResponseConverter;

    @Override
    public List<TaskResponse> getAllTasks(Long lessonId) {

        return taskResponseConverter.view(taskRepository.findAllTaskByLessonId(lessonId));
    }

    @Override
    public TaskResponse addTask(Long id, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(id).get();
        Task task = taskRequestConverter.createTask(taskRequest);
        lesson.addTask(task);
        task.setLesson(lesson);
        taskRepository.save(task);
        return taskResponseConverter.viewTask(task);

    }

    @Override
    public TaskResponse getTaskById(Long id) {

        return taskResponseConverter.viewTask(taskRepository.getById(id));
    }

    @Override
    public TaskResponse updateTask(TaskRequest taskRequest, Long id) {
        Task task1 = taskRepository.findById(id).get();
        taskRequestConverter.updateTask(task1, taskRequest);
        taskRepository.save(task1);
        return taskResponseConverter.viewTask(task1);

    }

    @Override
    public TaskResponse deleteTask(Long id) {
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
        return taskResponseConverter.viewTask(task);

    }
}
