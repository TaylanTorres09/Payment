package payment.com.api.payment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import payment.com.api.payment.models.Employee;
import payment.com.api.payment.models.OutSourcedEmployee;
import payment.com.api.payment.models.ResponseModel;
import payment.com.api.payment.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    
    @Autowired
    private EmployeeService es;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Employee emp) {
        return es.registerUpdate(emp, "register");
    }

    @PostMapping("/register/outSourced")
    public ResponseEntity<?> registerOut(@RequestBody OutSourcedEmployee emp) {
        return es.registerOrUpdateOut(emp, "register");
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Employee emp) {
        return es.registerUpdate(emp, "update");
    }

    @PostMapping("/update/outSourced")
    public ResponseEntity<?> updateOut(@RequestBody OutSourcedEmployee emp) {
        return es.registerOrUpdateOut(emp, "update");
    }

    @GetMapping("/listAll")
    public Iterable<Employee> listAll() {
        return es.listAll();
    }

    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    public List<HashMap<String, String>> listSalary() {
        Iterable<Employee> emp = es.listAll();
        List<HashMap<String, String>> response = new ArrayList<>();
        emp.forEach(obj -> {
            HashMap<String, String> resp = new HashMap<>();
            Double salary = obj.getValuePerHour() * obj.getHours();
            if(obj instanceof OutSourcedEmployee) {
                OutSourcedEmployee o = (OutSourcedEmployee) obj;
                salary += o.getAdditionalCharge() * 1.1;
                resp.put("additionalCharge", o.getAdditionalCharge().toString());
            }
            resp.put("id", obj.getId().toString());
            resp.put("name", obj.getName());
            resp.put("hours", obj.getHours().toString());
            resp.put("valuePerHour", obj.getValuePerHour().toString());
            resp.put("salary", salary.toString());
            response.add(resp);
        });
        return response;
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseModel> remove(@PathVariable long id){
        return es.remove(id);
    }

    @GetMapping("/")
    public String route() {
        return "Rotas da Aplicação: \n" +
            "- Cadastro de Funcionários: /register [POST] \n"+
            "- Cadastro de Funcionários Terceirizados: /register/outSourced [POST] \n" +
            "- Atualizar Funcionário: /update [POST] \n" +
            "- Atualizar Funcionário Terceirizado: /update/outSourced [POST] \n" +
            "- Listar Todos os Funcionários: /listAll [GET] \n" +
            "- Remover funcionário: /remove/{id} [DELETE] \n" +
            "- Salário e atributo de todos os funcionários: /salary [GET]";
    }

}
