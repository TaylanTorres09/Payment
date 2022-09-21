package payment.com.api.payment.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OutSourcedEmployee extends Employee{
    
    private Double additionalCharge;

}
