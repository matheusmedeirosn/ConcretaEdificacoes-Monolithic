package concreta.edificacoes.api.controller.estrutura;

import concreta.edificacoes.api.dto.estrutura.EstruturaDto;
import concreta.edificacoes.api.dto.estrutura.EstruturaDto;
import concreta.edificacoes.api.model.estrutura.Estrutura;
import concreta.edificacoes.api.model.estrutura.Estrutura;
import concreta.edificacoes.api.repository.estrutura.EstruturaRepository;
import concreta.edificacoes.api.service.EstruturaService;
import concreta.edificacoes.api.service.EstruturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EstruturaController {

    private final EstruturaService estruturaService;
    
    @Autowired
    private EstruturaRepository estruturaRepository;

    public EstruturaController(EstruturaService estruturaService) {
        this.estruturaService = estruturaService;
    }
    
    @GetMapping("/cadastroEstrutura")
    private String cadastroEstrutura(){
        return "estrutura/cadastroEstrutura";
    }

    @RequestMapping(value = "/cadastroEstrutura", method = RequestMethod.POST)
    public String cadastroEstrutura(EstruturaDto estruturaDto){

        var estrutura = new Estrutura(estruturaDto);

        estruturaRepository.save(estrutura);

        return "redirect:/cadastroEstrutura";
    }

    @RequestMapping("/visualizacaoEstrutura")
    public String listarEstruturas(Model model) {
        // Obtém a lista de estruturas do serviço
        List<Estrutura> estruturas = estruturaService.listarEstrutura();
        // Adiciona a lista de estruturas ao modelo para ser usada na página HTML
        model.addAttribute("estruturas", estruturas);
        // Retorna o nome da página HTML para ser exibida
        return "estrutura/visualizacaoEstrutura";
    }

    @RequestMapping(value = "/excluirEstrutura/{codEstrutura}", method = RequestMethod.GET)
    public String excluirEstrutura(@PathVariable("codEstrutura") String codEstrutura) {
        estruturaRepository.deleteById(String.valueOf(Long.parseLong(codEstrutura)));
        return "redirect:/visualizacaoEstrutura";
    }

    @RequestMapping(value = "/editarEstrutura/{codEstrutura}", method = RequestMethod.GET)
    public String editarEstrutura(@PathVariable("codEstrutura") Long codEstrutura, Model model) {
        Optional<Estrutura> optionalEstrutura = estruturaRepository.findById(String.valueOf(codEstrutura));

        if (optionalEstrutura.isPresent()) {
            Estrutura estrutura = optionalEstrutura.get();
            model.addAttribute("estrutura", estrutura);
            // Redireciona para a página de edição
            return "estrutura/editarEstrutura";
        } else {
            // Estrutura não encontrado, redireciona para algum lugar apropriado
            return "redirect:/visualizacaoEstrutura";
        }
    }

    @RequestMapping(value = "/salvarEstrutura", method = RequestMethod.POST)
    public String salvarEstrutura(@RequestParam("codEstrutura") Long codEstrutura, EstruturaDto estruturaDto) {
        Optional<Estrutura> optionalEstrutura = estruturaRepository.findById(String.valueOf(codEstrutura));

        if (optionalEstrutura.isPresent()) {
            Estrutura estrutura = optionalEstrutura.get();
            estrutura.setDescricao_estrutura(estruturaDto.descricao_estrutura());
            estrutura.setEstoque_max_estrutura(estruturaDto.estoque_max_estrutura());
            estrutura.setEstoque_min_estrutura(estruturaDto.estoque_min_estrutura());


            estruturaRepository.save(estrutura); // Salva as alterações no banco de dados
        }

        return "redirect:/visualizacaoEstrutura";
    }
}
