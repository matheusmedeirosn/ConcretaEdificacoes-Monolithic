package concreta.edificacoes.api.controller.profissional;

import concreta.edificacoes.api.dto.profissional.ProfissionalDto;
import concreta.edificacoes.api.model.profissional.Profissional;
import concreta.edificacoes.api.repository.profissional.ProfissionalRepository;
import concreta.edificacoes.api.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProfissionalController {

    private final ProfissionalService profissionalService;
    
    @Autowired
    private ProfissionalRepository profissionalRepository;

    public ProfissionalController(ProfissionalService profissionalService, ProfissionalRepository profissionalRepository) {
        this.profissionalService = profissionalService;
        this.profissionalRepository = profissionalRepository;
    }

    @RequestMapping("/cadastroProfissional")
    private String cadastroProfissional(){
        return "profissional/cadastroProfissional";
    }

    @RequestMapping(value = "/cadastroProfissional", method = RequestMethod.POST)
    public String cadastrarClienteJuridico(ProfissionalDto profissionalDto){

        var profissional = new Profissional(profissionalDto);

        profissionalRepository.save(profissional);

        return "redirect:/cadastroProfissional";
    }

    @RequestMapping("/visualizacaoProfissional")
    public String listarProfissionais(Model model) {
        // Obtém a lista de profissionals do serviço
        List<Profissional> profissionais = profissionalService.listarProfissional();
        // Adiciona a lista de profissionals ao modelo para ser usada na página HTML
        model.addAttribute("profissionais", profissionais);
        // Retorna o nome da página HTML para ser exibida
        return "profissional/visualizacaoProfissional";
    }

    @RequestMapping(value = "/excluirProfissional/{codProfissional}", method = RequestMethod.GET)
    public String excluirProfissional(@PathVariable("codProfissional") String codProfissional) {
        profissionalRepository.deleteById(String.valueOf(Long.parseLong(codProfissional)));
        return "redirect:/visualizacaoProfissional";
    }
}
