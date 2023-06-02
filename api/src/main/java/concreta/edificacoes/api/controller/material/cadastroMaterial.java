package concreta.edificacoes.api.controller.material;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class cadastroMaterial {

    @RequestMapping("/cadastroMaterial")
    private String cadastroMaterial(){
        return "material/cadastroMaterial";
    }

    @RequestMapping("/visualizacaoMaterial")
    private String visualizacaoMaterial(){
        return "material/visualizacaoMaterial";
    }

}
