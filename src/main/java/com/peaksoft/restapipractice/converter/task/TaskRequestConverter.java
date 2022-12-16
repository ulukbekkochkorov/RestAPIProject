package com.peaksoft.restapipractice.converter.task;

import com.peaksoft.restapipractice.dto.task.TaskRequest;
import com.peaksoft.restapipractice.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskRequestConverter {
    public Task createTask(TaskRequest taskRequest){
        if (taskRequest == null){
            return null;
        }
        Task task = new Task();

        task.setName((taskRequest.getName()));
        task.setText(taskRequest.getText());
        task.setDeadline(taskRequest.getDeadline());

        return task;
    }
    public void updateTask (Task task, TaskRequest taskRequest) {
        if (taskRequest.getName()!=null){
            task.setName(taskRequest.getName());
        }
        if (taskRequest.getText() != null) {
            task.setText(taskRequest.getText());
        }
        if (taskRequest.getDeadline()!=null){
            task.setDeadline(taskRequest.getDeadline());
        }
    }
}
