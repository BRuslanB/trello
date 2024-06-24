package kz.bitlab.portal.trello.service;

import kz.bitlab.portal.trello.model.Task;

import java.util.List;

public interface TaskService {

    Task addTask(Task task);
    List<Task> getAllTasks();
    Task getTask(Long id);
    Task saveTask (Task task);
    void deleteTask(Task task);

}
