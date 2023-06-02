package concreta.edificacoes.api.controller.configuracao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfiguracaoController {

    @RequestMapping("/configuracao")
    private String configuracao(){
        return "configuracao/configuracoes";
    }

    @RequestMapping("/configuracaoUsuario")
    private String configuracaoUsuario(){
        return "configuracao/configuracaoUsuario";
    }

    @RequestMapping("/configuracaoPerfis")
    private String configuracaoPerfis(){
        return "configuracao/configuracaoPerfis";
    }

}
