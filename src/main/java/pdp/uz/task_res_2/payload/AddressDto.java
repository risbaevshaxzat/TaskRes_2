package pdp.uz.task_res_2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {


    @NotNull(message = "street  kiritshibfiz shart !")
    private String street;

    @NotNull(message = "homeNumber kiritshingz shart !")
    private String homeNumber;


}
