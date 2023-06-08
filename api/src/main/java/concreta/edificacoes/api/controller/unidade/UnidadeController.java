package concreta.edificacoes.api.controller.unidade;

import concreta.edificacoes.api.dto.unidade.UnidadeDto;
import concreta.edificacoes.api.model.cliente.Cliente;
import concreta.edificacoes.api.model.projeto.Projeto;
import concreta.edificacoes.api.model.unidade.Unidade;
import concreta.edificacoes.api.repository.cliente.ClienteFisicoRepository;
import concreta.edificacoes.api.repository.cliente.ClienteRepository;
import concreta.edificacoes.api.repository.projeto.ProjetoRepository;
import concreta.edificacoes.api.repository.unidade.UnidadeRepository;
import concreta.edificacoes.api.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UnidadeController {

    private final UnidadeService unidadeService;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    ;

    @Autowired
    private ProjetoRepository projetoRepository;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @RequestMapping("/cadastroUnidade")
    public String cadastroUnidade(Model model) {
        // Chamar os métodos para buscar clientes e projetos
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        List<Projeto> projetos = (List<Projeto>) projetoRepository.findAll();

        // Adicionar os atributos de modelo
        model.addAttribute("clientes", clientes);
        model.addAttribute("projetos", projetos);

        return "unidade/cadastroUnidade";
    }

    @RequestMapping(value = "/cadastroUnidade", method = RequestMethod.POST)
    public String cadastroProfissional(UnidadeDto unidadeDto){

        var unidade = new Unidade(unidadeDto);

        unidadeRepository.save(unidade);

        return "redirect:/cadastroUnidade";
    }

    @RequestMapping("/visualizacaoUnidade")
    public String listarunidades(Model model) {
        // Obtém a lista de unidades do serviço
        List<Unidade> unidades = unidadeService.listarUnidade();
        // Adiciona a lista de unidades ao modelo para ser usada na página HTML
        model.addAttribute("unidades", unidades);
        // Retorna o nome da página HTML para ser exibida

        return "unidade/visualizacaoUnidade";
    }

    @RequestMapping(value = "/excluirUnidade/{codUnidade}", method = RequestMethod.GET)
    public String excluirUnidade(@PathVariable("codUnidade") String codUnidade) {
        unidadeRepository.deleteById(String.valueOf(Long.parseLong(codUnidade)));
        return "redirect:/visualizacaoUnidade";
    }

}
