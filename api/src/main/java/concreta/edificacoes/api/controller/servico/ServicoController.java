package concreta.edificacoes.api.controller.servico;

import concreta.edificacoes.api.dto.servico.ServicoDto;
import concreta.edificacoes.api.model.servico.Servico;
import concreta.edificacoes.api.repository.servico.ServicoRepository;
import concreta.edificacoes.api.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ServicoController {

    private final ServicoService servicoService;

    @Autowired
    private ServicoRepository servicoRepository;

    public ServicoController(ServicoService servicoService, ServicoRepository servicoRepository) {
        this.servicoService = servicoService;
        this.servicoRepository = servicoRepository;
    }

    @GetMapping("/cadastroServico")
    private String cadastroServico(){
        return "servico/cadastroServico";
    }

    @RequestMapping(value = "/cadastroServico", method = RequestMethod.POST)
    public String cadastroServico(ServicoDto servicoDto){

        var servico = new Servico(servicoDto);

        servicoRepository.save(servico);

        return "redirect:/cadastroServico";
    }

    @RequestMapping("/visualizacaoServico")
    public String listarservicos(Model model) {
        // Obtém a lista de servicos do serviço
        List<Servico> servicos = servicoService.listarServico();
        // Adiciona a lista de servicos ao modelo para ser usada na página HTML
        model.addAttribute("servicos", servicos);
        // Retorna o nome da página HTML para ser exibida
        return "servico/visualizacaoServico";
    }

    @RequestMapping(value = "/excluirServico/{codServico}", method = RequestMethod.GET)
    public String excluirServico(@PathVariable("codServico") String codServico) {
        servicoRepository.deleteById(String.valueOf(Long.parseLong(codServico)));
        return "redirect:/visualizacaoServico";
    }

}
