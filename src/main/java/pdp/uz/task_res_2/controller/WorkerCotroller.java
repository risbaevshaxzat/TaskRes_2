package pdp.uz.task_res_2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pdp.uz.task_res_2.Entity.Company;
import pdp.uz.task_res_2.Entity.Worker;
import pdp.uz.task_res_2.service.WorkerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class WorkerCotroller {

    private final WorkerService workerService;


    @PostMapping("/api/workers")
    public ResponseEntity<?> addWorker(@RequestBody Worker worker){
        Worker worker1 = workerService.addWorker(worker);
        return ResponseEntity.ok(worker1);
    }
    @GetMapping("/api/workers")
    public ResponseEntity<?> show(){
        List<Worker> workerList = workerService.showAll();
        return ResponseEntity.ok(workerList);
    }
    @GetMapping("/api/workers/{id}")
    public ResponseEntity<?> getWorker(@PathVariable("id") Integer id) {
        Worker worker = workerService.getWorkerById(id);
        return ResponseEntity.ok(worker);
    }
    @PutMapping("/api/workers/{id}")
    public ResponseEntity<?> updateWorker(@PathVariable Integer id) {
        Worker worker= workerService.updateWorker(id);
        return  ResponseEntity.ok(worker);
    }
    @DeleteMapping("/api/workers/{id}")
    public ResponseEntity deleteWorker(@PathVariable Integer id){
        Worker worker = workerService.deleteWorker(id);
        return ResponseEntity.ok(worker);
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
