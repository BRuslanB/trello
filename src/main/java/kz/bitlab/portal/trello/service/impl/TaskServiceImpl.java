package kz.bitlab.portal.trello.service.impl;

import kz.bitlab.portal.trello.model.Task;
import kz.bitlab.portal.trello.repository.TaskRepository;
import kz.bitlab.portal.trello.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.getReferenceById(id);
    }

    @Override
    public void saveTask(Task task) { taskRepository.save(task); }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
