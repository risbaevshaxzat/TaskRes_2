package pdp.uz.task_res_2.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pdp.uz.task_res_2.Entity.Company;
import pdp.uz.task_res_2.payload.ApiResponse;
import pdp.uz.task_res_2.payload.CompanyDto;
import pdp.uz.task_res_2.repo.CompanyRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;


    public Company addConpany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> showAll() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Integer id) {
        return companyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not found"));
    }

    public Company updateCompany(Integer id) {
        Company emp = companyRepository.getById(id);
        return companyRepository.save(emp);

    }

    public Company deleteCompany(Integer id) {
        companyRepository.deleteById(id);
        return null;
    }

}


