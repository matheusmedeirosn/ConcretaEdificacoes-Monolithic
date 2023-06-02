package concreta.edificacoes.api.controller.profissional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfissionalController {

    @RequestMapping("/cadastroProfissional")
    private String cadastroProfissional(){
        return "profissional/cadastroProfissional";
    }

    @RequestMapping("/visualizacaoProfissional")
    private String visualizacaoProfissional(){
        return "profissional/visualizacaoProfissional";
    }

}
