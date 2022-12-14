package pdp.uz.task_res_2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer id ;

    @Column(nullable = true)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false,name = "company_id")
    private Company company;
}
