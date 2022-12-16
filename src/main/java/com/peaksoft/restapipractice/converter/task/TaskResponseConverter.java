package com.peaksoft.restapipractice.converter.task;

import com.peaksoft.restapipractice.dto.task.TaskResponse;
import com.peaksoft.restapipractice.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskResponseConverter {
    public TaskResponse viewTask(Task task) {
        if (task == null) {
            return null;
        }
        TaskResponse taskResponse = new TaskResponse();

        taskResponse.setId(task.getId());
        taskResponse.setName(task.getName());
        taskResponse.setText(task.getText());
        taskResponse.setDeadline(task.getDeadline());

        return taskResponse;
    }

    public List<TaskResponse> view(List<Task> tasks){
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (Task task: tasks) {
            taskResponses.add(viewTask(task));
        }
        return taskResponses;
    }

}
