package payment.com.api.payment.models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class LoginUser {

    private String email;
    private String password;
    
}
