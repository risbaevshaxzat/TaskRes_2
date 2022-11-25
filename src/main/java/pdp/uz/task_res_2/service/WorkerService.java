package pdp.uz.task_res_2.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pdp.uz.task_res_2.Entity.Department;
import pdp.uz.task_res_2.Entity.Worker;
import pdp.uz.task_res_2.repo.WorkerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public List<Worker> showAll() {
        return workerRepository.findAll();
    }

    public Worker getWorkerById(Integer id) {
        return workerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not found"));
    }

    public Worker updateWorker(Integer id) {
        Worker worker = workerRepository.getById(id);
        return workerRepository.save(worker);

    }

    public Worker deleteWorker(Integer id) {
        workerRepository.deleteById(id);
        return null;
          }
    }

