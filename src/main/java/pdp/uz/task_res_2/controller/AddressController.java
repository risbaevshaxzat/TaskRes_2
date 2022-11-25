package pdp.uz.task_res_2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pdp.uz.task_res_2.Entity.Address;
import pdp.uz.task_res_2.payload.AddressDto;
import pdp.uz.task_res_2.payload.ApiResponse;
import pdp.uz.task_res_2.service.AddressService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/api/address")
    public ResponseEntity<List<Address>> getAll(){
        List<Address> customerList= addressService.getAll();
        return  ResponseEntity.ok(customerList);
    }
    @GetMapping("/api/addres/{id}")
    public  ResponseEntity<?> getCustomer(@PathVariable Integer id) {
        Address customer = addressService.getCustomerById(id);
        //  return id;
        return  ResponseEntity.ok(customer);
    }
    @PostMapping("/api/address")
    public HttpEntity<?> createCustomer(@Valid @RequestBody Address address){
         Address address1 = addressService.addAddress(address);
        return ResponseEntity.ok(address1);

    }

    @PutMapping("/api/address/{id}")
    public ResponseEntity<?> editAddress(@Valid @PathVariable Integer id , @RequestBody AddressDto addressDto){
        Address address = addressService.finAlId(id);
        return  ResponseEntity.ok(address);
    }

    @DeleteMapping("/api/customer/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id ){
        Address address = addressService.deleteAddressById(id);
        return  ResponseEntity.ok(address);

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

