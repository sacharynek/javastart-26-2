package javastart.javastart262.service;

import javastart.javastart262.model.Task;
import javastart.javastart262.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TaskService {


    private TaskRepository repo;//tutaj wstrzyknąć enetity manager factory

    public List<Task> listAll() {
        return repo.findAll();
    }

    public void save(Task task) {
        repo.save(task);
    }

    public Optional<Task> get(long id) {
        return repo.findById(id);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

}
