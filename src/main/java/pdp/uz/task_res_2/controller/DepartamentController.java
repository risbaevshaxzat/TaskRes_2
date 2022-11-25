package pdp.uz.task_res_2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pdp.uz.task_res_2.Entity.Department;
import pdp.uz.task_res_2.service.DepartmentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class DepartamentController {

    private final DepartmentService departmentService;

    @PostMapping("/api/department")
    public ResponseEntity<?> addDepartament(@RequestBody Department department){
        Department department1 = departmentService.addDepartament(department);
        return ResponseEntity.ok(department1);
    }
    @GetMapping("/api/department")
    public ResponseEntity<?> show(){
        List<Department> departmentList = departmentService.showAll();
        return ResponseEntity.ok(departmentList);
    }

    @GetMapping("/api/department/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable("id") Integer id) {
        Department department = departmentService.getDepartamentById(id);
        return ResponseEntity.ok(department);
    }
    @PutMapping("/api/department/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer id) {
        Department department= departmentService.updateDepartament(id);
        return  ResponseEntity.ok(department);
    }
    @DeleteMapping("/api/department/{id}")
    public ResponseEntity deleteDepartment(@PathVariable Integer id){
        Department department = departmentService.deleteDepartament(id);
        return ResponseEntity.ok(department);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
