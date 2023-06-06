package concreta.edificacoes.api.controller.material;

import concreta.edificacoes.api.dto.estrutura.EstruturaDto;
import concreta.edificacoes.api.dto.material.MaterialDto;
import concreta.edificacoes.api.model.estrutura.Estrutura;
import concreta.edificacoes.api.model.material.Material;
import concreta.edificacoes.api.repository.material.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class cadastroMaterial {

    @Autowired
    private MaterialRepository materialRepository;

    @RequestMapping("/cadastroMaterial")
    private String cadastroMaterial(){
        return "material/cadastroMaterial";
    }

    @RequestMapping(value = "/cadastroMaterial", method = RequestMethod.POST)
    public String cadastroMaterial(MaterialDto materialDto){

        var material = new Material(materialDto);

        materialRepository.save(material);

        return "redirect:/cadastroMaterial";
    }

    @RequestMapping("/visualizacaoMaterial")
    private String visualizacaoMaterial(){
        return "material/visualizacaoMaterial";
    }

}
