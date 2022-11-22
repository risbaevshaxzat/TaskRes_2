package pdp.uz.task_res_2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotBlank(message = "fullname  bolishi kerak")
    private String fullName;

    @NotBlank(message = "phoneNumber  bolishi kerak")
    private String phoneNumber;

    @NotBlank(message = "address bolishi kerak")
    private String addrese;

}
