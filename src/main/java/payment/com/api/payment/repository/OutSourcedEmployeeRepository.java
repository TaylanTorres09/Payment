package payment.com.api.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import payment.com.api.payment.models.OutSourcedEmployee;

@Repository
public interface OutSourcedEmployeeRepository extends CrudRepository<OutSourcedEmployee, Long>{
    
}
