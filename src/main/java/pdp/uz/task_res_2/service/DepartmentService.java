package pdp.uz.task_res_2.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pdp.uz.task_res_2.Entity.Department;
import pdp.uz.task_res_2.repo.DepartmentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private  final DepartmentRepository departmentRepository;


    public Department addDepartament(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> showAll() {
        return departmentRepository.findAll();
    }

    public Department getDepartamentById(Integer id) {
        return departmentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not found"));
    }

    public Department updateDepartament(Integer id) {
        Department emp = departmentRepository.getById(id);
        return departmentRepository.save(emp);

    }

    public Department deleteDepartament(Integer id) {
        departmentRepository.deleteById(id);
        return null;
    }
}
