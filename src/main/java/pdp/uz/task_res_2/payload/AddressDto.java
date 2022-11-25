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


    @NotNull(message = "First street is required !")
    private String street;

    @NotNull(message = "First homeNumber is required !")
    private String homeNumber;


}
