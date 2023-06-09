package concreta.edificacoes.api.controller.servico;

import concreta.edificacoes.api.dto.servico.ServicoDto;
import concreta.edificacoes.api.model.servico.Servico;
import concreta.edificacoes.api.repository.servico.ServicoRepository;
import concreta.edificacoes.api.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/editarServico/{codServico}", method = RequestMethod.GET)
    public String editarServico(@PathVariable("codServico") Long codServico, Model model) {
        Optional<Servico> optionalServico = servicoRepository.findById(String.valueOf(codServico));

        if (optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            model.addAttribute("servico", servico);
            // Redireciona para a página de edição
            return "servico/editarServico";
        } else {
            // Servico não encontrado, redireciona para algum lugar apropriado
            return "redirect:/visualizacaoServico";
        }
    }

    @RequestMapping(value = "/salvarServico", method = RequestMethod.POST)
    public String salvarServico(@RequestParam("codServico") Long codServico, ServicoDto servicoDto) {
        Optional<Servico> optionalServico = servicoRepository.findById(String.valueOf(codServico));

        if (optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            servico.setPreco_servico(servicoDto.preco_servico());
            servico.setPrevisao_termino_servico(servicoDto.previsao_termino_servico());

            servicoRepository.save(servico); // Salva as alterações no banco de dados
        }

        return "redirect:/visualizacaoServico";
    }
    
}
