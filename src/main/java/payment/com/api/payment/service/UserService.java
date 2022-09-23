package payment.com.api.payment.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import payment.com.api.payment.models.ResponseModel;
import payment.com.api.payment.models.User;
import payment.com.api.payment.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    @Autowired
    private ResponseModel rm;

    // Method List all Users
    public Iterable<User> listUsers() {
        return ur.findAll();
    }

}