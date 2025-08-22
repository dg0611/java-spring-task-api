package todo_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class TesteRotaController {
    @GetMapping("/hello")
    public String helloAdmin() {
        return "Olá, administrador!";
    }


    @RestController
    @RequestMapping("/user")
    public class UserController {
        @GetMapping("/hello")
        public String helloUser() {
            return "Olá, usuário autenticado!";
        }
    }

}