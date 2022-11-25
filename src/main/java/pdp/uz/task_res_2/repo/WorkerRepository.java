package pdp.uz.task_res_2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.task_res_2.Entity.Department;
import pdp.uz.task_res_2.Entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
