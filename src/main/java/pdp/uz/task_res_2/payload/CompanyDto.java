package pdp.uz.task_res_2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pdp.uz.task_res_2.Entity.Company;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {



    @NotEmpty(message = "First corpName is required")
    private String corpName;


    @NotEmpty(message = "First directorName is required")
    private String directorName;


    @NotEmpty(message = "First address is required")
    private String address;

  // public static CompanyDto mapper(Company company) {
  //     return new CompanyDto(company.getCorpName(),);
  // }
}
