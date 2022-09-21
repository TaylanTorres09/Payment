package payment.com.api.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import payment.com.api.payment.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    
}
