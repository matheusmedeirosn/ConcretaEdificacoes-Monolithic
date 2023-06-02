package concreta.edificacoes.api.controller.estrutura;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstruturaController {

    @RequestMapping("/cadastroEstrutura")
    private String cadastroEstrutura(){
        return "estrutura/cadastroEstrutura";
    }

    @RequestMapping("/estrutura/cadastroEstrutura")
    private String visualizacaoEstrutura(){
        return "estrutura/visualizacaoEstrutura";
    }

}
