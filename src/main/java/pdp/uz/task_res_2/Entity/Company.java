package pdp.uz.task_res_2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false )
    @NotEmpty(message = "First corpName is required")
    private String corpName;

    @Column(nullable = false)
    @NotEmpty(message = "First directorName is required")
    private String directorName;

    @OneToOne
    @JoinColumn(nullable = false,name = "addres_id")
    private Address address;
}
