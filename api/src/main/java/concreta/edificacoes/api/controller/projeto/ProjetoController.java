package concreta.edificacoes.api.controller.projeto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjetoController {

    @RequestMapping("/cadastroProjeto")
    private String cadastroProjeto(){
        return "projeto/cadastroProjeto";
    }

}
