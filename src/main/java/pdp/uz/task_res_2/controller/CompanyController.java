package pdp.uz.task_res_2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pdp.uz.task_res_2.Entity.Company;
import pdp.uz.task_res_2.payload.CompanyDto;
import pdp.uz.task_res_2.service.CompanyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/api/companys")
    public ResponseEntity<?>  addCompany(@RequestBody Company company){
       Company company1 = companyService.addConpany(company);
        return ResponseEntity.ok(company1);
    }
    @GetMapping("/api/companys")
    public ResponseEntity<?> show(){
        List<Company> companyList = companyService.showAll();
        return ResponseEntity.ok(companyList);
    }
    @GetMapping("/api/companys/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") Integer id) {
        Company company = companyService.getCompanyById(id);
       return ResponseEntity.ok(company);
    }
    @PutMapping("/api/companys/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable Integer id) {
        Company company1= companyService.updateCompany(id);
        return  ResponseEntity.ok(company1);
    }
    @DeleteMapping("/api/companys/{id}")
    public ResponseEntity deleteCompanys(@PathVariable Integer id){
        Company company = companyService.deleteCompany(id);
        return ResponseEntity.ok(company);
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
