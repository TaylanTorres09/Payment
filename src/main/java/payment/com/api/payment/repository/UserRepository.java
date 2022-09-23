package payment.com.api.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import payment.com.api.payment.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
}
