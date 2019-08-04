package javastart.javastart262.controller;

import javastart.javastart262.model.Task;
import javastart.javastart262.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Controller
public class AppController {

    private EntityManager entityManager;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");


    public AppController() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Task> listTasks = service.listAll();
        model.addAttribute("taskList", listTasks);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewTaskPage(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);

        return "new_task";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("task") Task task) {
        service.save(task);

        return "redirect:/";
    }


}
