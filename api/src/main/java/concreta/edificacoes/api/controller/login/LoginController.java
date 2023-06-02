package concreta.edificacoes.api.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    private String login(){
        return "login/login";
    }

    @RequestMapping("/soliciteSuaConta")
    private String soliciteSuaConta(){
        return "login/soliciteSuaConta";
    }

    @RequestMapping("/atencao")
    private String soliciteSuaContaAtencao(){
        return "login/atencao";
    }

    @RequestMapping("/esqueciMinhaSenha")
    private String esqueciMinhaSenha(){
        return "login/esqueceuSuaSenha";
    }

    @RequestMapping("/codigo")
    private String esqueciMinhaSenhaCodigo(){
        return "login/codigo";
    }

    @RequestMapping("/novaSenha")
    private String novaSenha(){
        return "login/novaSenha";
    }

}
