package pdp.uz.task_res_2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.task_res_2.Entity.Address;
import pdp.uz.task_res_2.repo.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;


    public List<Address> getAll(){
        List<Address> customerList = addressRepository.findAll();
        return customerList;
    }

    public Address  getCustomerById(Integer id){
        Optional<Address> optionalCustomer = Optional.of(addressRepository.getOne(id));
        return optionalCustomer.orElse(null);
    }

    public Address addAddress(Address address){
        return addressRepository.save(address);
    }

    public Address  finAlId(Integer id){
        return addressRepository.findById(id).get();
    }

    public Address deleteAddressById(int id) {
        addressRepository.deleteById(id);
       return null;
    }

}


