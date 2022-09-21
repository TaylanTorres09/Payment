package payment.com.api.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import payment.com.api.payment.models.Employee;
import payment.com.api.payment.models.OutSourcedEmployee;
import payment.com.api.payment.models.ResponseModel;
import payment.com.api.payment.repository.EmployeeRepository;
import payment.com.api.payment.repository.OutSourcedEmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository er;

    @Autowired
    private OutSourcedEmployeeRepository oser;

    @Autowired
    private ResponseModel rm;

    // Method list all Employees
    public Iterable<Employee> listAll() {
        return er.findAll();
    }

    // Method to register Employees
    public ResponseEntity<?> registerUpdate(Employee emp, String toDo) {

        if(emp.getName().equals("")) {
            rm.setMensage("O nome do funcionário é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else if(emp.getHours() == null) {
            rm.setMensage("Quantidade de horas é obrigatória!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else if(emp.getValuePerHour() == null) {
            rm.setMensage("Valor por hora é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(toDo == "register") {
                return new ResponseEntity<Employee>(er.save(emp), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Employee>(er.save(emp), HttpStatus.OK);
            }
        }
    }

    // Method to register EmployeesOutSourced
    public ResponseEntity<?> registerOrUpdateOut(OutSourcedEmployee emp, String toDo) {

        if(emp.getName().equals("")) {
            rm.setMensage("O nome do funcionário é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else if(emp.getHours() == null) {
            rm.setMensage("Quantidade de horas é obrigatória!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else if(emp.getValuePerHour() == null) {
            rm.setMensage("Valor por hora é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else if(emp.getAdditionalCharge() == null) {
            rm.setMensage("Adicional é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(toDo == "register") {
                return new ResponseEntity<OutSourcedEmployee>(oser.save(emp), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<OutSourcedEmployee>(oser.save(emp), HttpStatus.OK);

            }
        }
    }

    // Method to remove employees
    public ResponseEntity<ResponseModel> remove(long id) {
        er.deleteById(id);

        rm.setMensage("Funcionário removido com sucesso");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }
    
}
