package pdp.uz.task_res_2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(nullable = false)
    private  String  name;

    @Column(nullable = true)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(nullable = false,name = "addresss")
    private Address address;

    @OneToOne
    @JoinColumn(nullable = false,name = "department_id")
    private Department department;

}
