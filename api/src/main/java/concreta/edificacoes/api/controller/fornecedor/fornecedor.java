package concreta.edificacoes.api.controller.fornecedor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class fornecedor {

    @RequestMapping("/cadastroFornecedor")
    private String cadastroFornecedor(){
        return "fornecedor/cadastroFornecedor";
    }

    @RequestMapping("/visualizacaoFornecedor")
    private String visualizacaoFornecedor(){
        return "fornecedor/visualizacaoFornecedor";
    }

}
