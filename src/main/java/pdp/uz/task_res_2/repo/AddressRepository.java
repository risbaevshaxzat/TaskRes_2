package pdp.uz.task_res_2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pdp.uz.task_res_2.Entity.Address;

public interface AddressRepository extends JpaRepository<Address , Integer> {
    boolean existsBystreet(String street);
    boolean existsByStreetAndIdNot(String street, Integer id);
}
