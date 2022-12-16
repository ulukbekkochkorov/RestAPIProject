package com.peaksoft.restapipractice.controller;

import com.peaksoft.restapipractice.dto.task.TaskRequest;
import com.peaksoft.restapipractice.dto.task.TaskResponse;
import com.peaksoft.restapipractice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/getAllByLessonId/{lessonId}")
    public List<TaskResponse> getAllTasks(@PathVariable Long lessonId){
        return taskService.getAllTasks(lessonId);
        }

        @PostMapping("/save/{id}")
    public TaskResponse saveTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) throws IOException {
        return taskService.addTask(id, taskRequest);
        }

        @GetMapping("/findById/{id}")
    public TaskResponse findById(@PathVariable Long id){
        return taskService.getTaskById(id);
        }

        @DeleteMapping("/deleteById/{id}")
    public TaskResponse deleteById (@PathVariable Long id) {
        return  taskService.deleteTask(id);
        }
        @PutMapping("/update/{id}")
    public TaskResponse updateTask(@RequestBody TaskRequest taskRequest,@PathVariable Long id) throws IOException {
            return taskService.updateTask(taskRequest, id);
        }
}
