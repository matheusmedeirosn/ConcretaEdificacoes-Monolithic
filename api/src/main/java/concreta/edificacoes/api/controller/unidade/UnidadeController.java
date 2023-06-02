package concreta.edificacoes.api.controller.unidade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnidadeController {

    @RequestMapping("/cadastroUnidade")
    private String cadastroProfissional(){
        return "unidade/visualizacaoUnidade";
    }

    @RequestMapping("/visualizacaoUnidade")
    private String visualizacaoProfissional(){
        return "unidade/visualizacaoUnidade";
    }

}
