package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import todolist.bindingModel.TaskBindingModel;
import todolist.entity.Task;
import todolist.repository.TaskRepository;

import java.util.List;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("view", "task/index");
        return "base-layout";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("task", new TaskBindingModel());
        model.addAttribute("view", "task/create");
        return "base-layout";
    }

    @PostMapping("/create")
    public String createPost(Model model, TaskBindingModel taskBindingModel) {
        if (taskBindingModel.getTitle().equals("") ||
                taskBindingModel.getComments().equals("")) {
            model.addAttribute("task", taskBindingModel);
            model.addAttribute("view", "task/create");
            return "base-layout";
        }

        Task task = new Task();
        task.setTitle(taskBindingModel.getTitle());
        task.setComments(taskBindingModel.getComments());
        taskRepository.saveAndFlush(task);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        Task task = taskRepository.findOne(id);
        if (task != null) {
            model.addAttribute("task", task);
            model.addAttribute("view", "task/delete");
            return "base-layout";
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(Model model, @PathVariable int id) {
        try {
            taskRepository.delete(id);
        } catch (Exception ex) {
            // Task was not found -> do nothing
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Task task = taskRepository.findOne(id);
        if (task != null) {
            model.addAttribute("task", task);
            model.addAttribute("view", "task/edit");
            return "base-layout";
        }
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editTask(
            Model model, @PathVariable int id, TaskBindingModel taskBindingModel) {
        if (taskBindingModel.getTitle().equals("") ||
                taskBindingModel.getComments().equals("")) {
            Task task = new Task();
            task.setId(id);
            task.setTitle(taskBindingModel.getTitle());
            task.setComments(taskBindingModel.getComments());
            model.addAttribute("task", task);
            model.addAttribute("view", "task/edit");
            return "base-layout";
        }

        Task task = taskRepository.findOne(id);
        if (task != null) {
            task.setTitle(taskBindingModel.getTitle());
            task.setComments(taskBindingModel.getComments());
            taskRepository.saveAndFlush(task);
        }

        return "redirect:/";
    }
}
