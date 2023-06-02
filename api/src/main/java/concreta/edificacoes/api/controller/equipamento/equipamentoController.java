package concreta.edificacoes.api.controller.equipamento;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class equipamentoController {

    @RequestMapping("/cadastroEquipamento")
    private String cadastroEquipamento(){
        return "equipamento/cadastroEquipamento";
    }

    @RequestMapping("visualizacaoEquipamento")
    private String visualizacaoEquipamento(){
        return "equipamento/visualizacaoEquipamento";
    }
}
