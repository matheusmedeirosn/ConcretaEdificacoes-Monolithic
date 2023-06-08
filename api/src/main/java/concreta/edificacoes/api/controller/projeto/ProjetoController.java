package concreta.edificacoes.api.controller.projeto;

import concreta.edificacoes.api.dto.projeto.ProjetoDto;
import concreta.edificacoes.api.model.cliente.Cliente;
import concreta.edificacoes.api.model.profissional.Profissional;
import concreta.edificacoes.api.model.projeto.Projeto;
import concreta.edificacoes.api.repository.profissional.ProfissionalRepository;
import concreta.edificacoes.api.repository.projeto.ProjetoRepository;
import concreta.edificacoes.api.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjetoController {

    private final ProjetoService projetoService;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public ProjetoController(ProjetoService projetoService, ProjetoRepository projetoRepository) {
        this.projetoService = projetoService;
        this.projetoRepository = projetoRepository;
    }

    @GetMapping("/cadastroProjeto")
    private String cadastroProjeto(Model model) {
        List<Profissional> profissionais = (List<Profissional>) profissionalRepository.findAll();
        List<Profissional> engenheiros = new ArrayList<>();

        for (Profissional profissional : profissionais) {
            if (profissional.getFuncao_profissional().equals("Engenheiro")) {
                engenheiros.add(profissional);
            }
        }

        // Adicionar os atributos de modelo
        model.addAttribute("profissionais", engenheiros);
        return "projeto/cadastroProjeto";
    }


    @RequestMapping(value = "/cadastroProjeto", method = RequestMethod.POST)
    public String cadastroProjeto(ProjetoDto projetoDto){

        var projeto = new Projeto(projetoDto);

        projetoRepository.save(projeto);

        return "redirect:/cadastroProjeto";
    }

    @RequestMapping("/visualizacaoProjeto")
    public String listarprojetos(Model model) {
        // Obtém a lista de projetos do serviço
        List<Projeto> projetos = projetoService.listarProjeto();
        // Adiciona a lista de projetos ao modelo para ser usada na página HTML
        model.addAttribute("projetos", projetos);
        // Retorna o nome da página HTML para ser exibida
        return "projeto/visualizacaoProjeto";
    }

    @RequestMapping(value = "/excluirProjeto/{codProjeto}", method = RequestMethod.GET)
    public String excluirProjeto(@PathVariable("codProjeto") String codProjeto) {
        projetoRepository.deleteById(String.valueOf(Long.parseLong(codProjeto)));
        return "redirect:/visualizacaoProjeto";
    }
    
}
