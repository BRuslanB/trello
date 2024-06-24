package kz.bitlab.portal.trello.controller;

import kz.bitlab.portal.trello.model.Task;
import kz.bitlab.portal.trello.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final TaskService taskService;

    @GetMapping(value = "/")
    public String indexPage(Model model){

        List<Task> taskList = taskService.getAllTasks();
        model.addAttribute("tasks", taskList);

        return "index";
    }

    @PostMapping(value = "/addtask")
    public String addTask(@RequestParam(name = "task_title") String taskTitle,
                          @RequestParam(name = "task_description") String taskDescription,
                          @RequestParam(name = "task_deadline_date") LocalDate taskDeadlineDate,
                          @RequestParam(name = "task_status") int taskStatus){

        Task task = new Task();

        task.setTitle(taskTitle);
        task.setDescription(taskDescription);
        task.setDeadlineDate(taskDeadlineDate);
        task.setStatus(taskStatus);

        taskService.saveTask(task);

        return "redirect:/";
    }

    @PostMapping(value = "/edittask")
    public String editTask(@RequestParam(name = "task_id") Long taskId,
                           @RequestParam(name = "task_title") String taskTitle,
                           @RequestParam(name = "task_description") String taskDescription,
                           @RequestParam(name = "task_deadline_date") LocalDate taskDeadlineDate,
                           @RequestParam(name = "task_status") int taskStatus){

        Task task = taskService.getTask(taskId);

        if (task != null){

            task.setTitle(taskTitle);
            task.setDescription(taskDescription);
            task.setDeadlineDate(taskDeadlineDate);
            task.setStatus(taskStatus);

            taskService.saveTask(task);
        }

        return "redirect:/";
    }

    @PostMapping(value = "/deletetask")
    public String deleteTask(@RequestParam(name = "task_id") Long taskId){

        Task task = taskService.getTask(taskId);

        if (task != null) {
            taskService.deleteTask(task);
        }

        return "redirect:/";
    }
}
