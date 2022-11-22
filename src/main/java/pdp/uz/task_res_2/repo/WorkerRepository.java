package pdp.uz.task_res_2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.task_res_2.Entity.Department;

public interface WorkerRepository extends JpaRepository<Department, Integer> {
}
