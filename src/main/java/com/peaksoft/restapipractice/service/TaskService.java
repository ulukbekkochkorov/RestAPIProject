package com.peaksoft.restapipractice.service;
import com.peaksoft.restapipractice.dto.task.TaskRequest;
import com.peaksoft.restapipractice.dto.task.TaskResponse;
import com.peaksoft.restapipractice.entity.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks(Long lessonId);

    TaskResponse addTask(Long id, TaskRequest taskRequest);

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(TaskRequest taskRequest, Long id);

    TaskResponse deleteTask(Long id);
}
