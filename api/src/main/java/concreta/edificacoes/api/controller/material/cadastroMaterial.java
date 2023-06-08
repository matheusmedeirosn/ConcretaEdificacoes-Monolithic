package concreta.edificacoes.api.controller.material;

import concreta.edificacoes.api.dto.material.MaterialDto;
import concreta.edificacoes.api.model.material.Material;
import concreta.edificacoes.api.repository.material.MaterialRepository;
import concreta.edificacoes.api.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class cadastroMaterial {

    private final MaterialService materialService;
    
    @Autowired
    private MaterialRepository materialRepository;

    public cadastroMaterial(MaterialService materialService) {
        this.materialService = materialService;
    }

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
    public String listarMaterials(Model model) {
        // Obtém a lista de materials do serviço
        List<Material> materiais = materialService.listarMaterial();
        // Adiciona a lista de materials ao modelo para ser usada na página HTML
        model.addAttribute("materiais", materiais);
        // Retorna o nome da página HTML para ser exibida
        return "material/visualizacaoMaterial";
    }

    @RequestMapping(value = "/excluirMaterial/{codMaterial}", method = RequestMethod.GET)
    public String excluirMaterial(@PathVariable("codMaterial") String codMaterial) {
        materialRepository.deleteById(String.valueOf(Long.parseLong(codMaterial)));
        return "redirect:/visualizacaoMaterial";
    }


}
