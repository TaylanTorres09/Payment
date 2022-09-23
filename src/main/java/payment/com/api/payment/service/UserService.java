package payment.com.api.payment.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private String string;

    // Method List all Users
    public Iterable<User> listUsers() {
        return ur.findAll();
    }

    // Method Register User
    public ResponseEntity<?> registerUser(User user) {
        // Validate e-mail
        Pattern patternEmail = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za- z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher matchEmail = patternEmail.matcher(user.getEmail());

        // Validate password
        Pattern patternPass = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
        Matcher matchPass = patternPass.matcher(user.getPassword());

        if(user.getName().equals("")) {
            rm.setMensage("O nome é obrigatório!");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else if(!matchEmail.find()) {
            String[] message = {
                "Só é permitido: ",
                "Valores numéricos de 0 a 9.",
                "Letras maiúsculas e minúsculas de a a z são permitidas.",
                "São permitidos sublinhado '_', hífen '-' e ponto '.'",
                "O ponto não é permitido no início e no final da parte local.",
                "Pontos consecutivos não são permitidos.",
                "Para a parte local, são permitidos no máximo 64 caracteres."
            };
            StringBuilder sb = new StringBuilder();
            for (String line: message) {
                sb.append(line).append(System.lineSeparator());
            }
            String msg = sb.toString();
            rm.setMensage(msg);
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else if(!matchPass.find()) {
            String[] message = {
                "A senha deve conter: ",
                "Pelo menos um dígito [0-9].",
                "Pelo menos um caractere latino minúsculo [az].",
                "Pelo menos um caractere latino maiúsculo [AZ].",
                "Pelo menos um caractere especial como ! @ # & ( ).",
                "No mínimo 8 caracteres e no máximo 20 caracteres."
            };
            StringBuilder sb = new StringBuilder();
            for (String line: message) {
                sb.append(line).append(System.lineSeparator());
            }
            String msg = sb.toString();
            rm.setMensage(msg);
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<User>(ur.save(user), HttpStatus.CREATED);
        }

    }

}