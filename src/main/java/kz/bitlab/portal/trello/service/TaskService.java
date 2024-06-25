package kz.bitlab.portal.trello.service;

import kz.bitlab.portal.trello.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();
    Task getTask(Long id);
    void  saveTask (Task task);
    void deleteTask(Task task);

}
