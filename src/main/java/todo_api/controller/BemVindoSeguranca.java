package todo_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class BemVindoSeguranca {

    @GetMapping("/users")
    public String retornaNome(){
        return "Pagina do usuario";
    }
    @GetMapping("/managers")
    public String retornaNomeAdm(){
        return "Pagina do ADMIn";
    }


}
