package pdp.uz.task_res_2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.task_res_2.Entity.Address;
import pdp.uz.task_res_2.Entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
