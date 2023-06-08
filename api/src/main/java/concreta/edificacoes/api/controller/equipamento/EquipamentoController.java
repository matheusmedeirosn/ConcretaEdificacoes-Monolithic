package concreta.edificacoes.api.controller.equipamento;

import concreta.edificacoes.api.dto.equipamento.EquipamentoDto;
import concreta.edificacoes.api.model.cliente.Cliente;
import concreta.edificacoes.api.model.equipamento.Equipamento;
import concreta.edificacoes.api.model.projeto.Projeto;
import concreta.edificacoes.api.model.unidade.Unidade;
import concreta.edificacoes.api.repository.equipamento.EquipamentoRepository;
import concreta.edificacoes.api.repository.unidade.UnidadeRepository;
import concreta.edificacoes.api.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @GetMapping("/cadastroEquipamento")
    private String cadastroEquipamento(Model model){

        List<Unidade> unidades = (List<Unidade>) unidadeRepository.findAll();

        // Adicionar os atributos de modelo
        model.addAttribute("unidades", unidades);

        return "equipamento/cadastroEquipamento";
    }

    @RequestMapping(value = "/cadastroEquipamento", method = RequestMethod.POST)
    public String cadastroEquipamento(EquipamentoDto equipamentoDto){

        var equipamento = new Equipamento(equipamentoDto);

        equipamentoRepository.save(equipamento);

        return "redirect:/cadastroEquipamento";
    }

    @RequestMapping("/visualizacaoEquipamento")
    public String listarEquipamentos(Model model) {
        // Obtém a lista de equipamentos do serviço
        List<Equipamento> equipamentos = equipamentoService.listarEquipamentos();
        // Adiciona a lista de equipamentos ao modelo para ser usada na página HTML
        model.addAttribute("equipamentos", equipamentos);
        // Retorna o nome da página HTML para ser exibida
        return "equipamento/visualizacaoEquipamento";
    }

    public String buscarEquipamentos(Model model) {
        List<Unidade> unidades = (List<Unidade>) unidadeRepository.findAll();
        model.addAttribute("unidades", unidades);
        return "resultadoEquipamentos";
    }

    @RequestMapping(value = "/excluirEquipamento/{codEquipamento}", method = RequestMethod.GET)
    public String excluirEquipamento(@PathVariable("codEquipamento") String codEquipamento) {
        equipamentoRepository.deleteById(String.valueOf(Long.parseLong(codEquipamento)));
        return "redirect:/visualizacaoEquipamento";
    }

    @RequestMapping(value = "/editarEquipamento/{codEquipamento}", method = RequestMethod.GET)
    public String editarEquipamento(@PathVariable("codEquipamento") Long codEquipamento, Model model) {
        Optional<Equipamento> optionalEquipamento = equipamentoRepository.findById(String.valueOf(codEquipamento));

        if (optionalEquipamento.isPresent()) {
            Equipamento equipamento = optionalEquipamento.get();
            model.addAttribute("equipamento", equipamento);
            // Redireciona para a página de edição
            return "equipamento/editarEquipamento";
        } else {
            // Equipamento não encontrado, redireciona para algum lugar apropriado
            return "redirect:/visualizacaoEquipamento";
        }
    }

    @RequestMapping(value = "/salvarEquipamento", method = RequestMethod.POST)
    public String salvarEquipamento(@RequestParam("codEquipamento") Long codEquipamento, EquipamentoDto equipamentoDto) {
        Optional<Equipamento> optionalEquipamento = equipamentoRepository.findById(String.valueOf(codEquipamento));

        if (optionalEquipamento.isPresent()) {
            Equipamento equipamento = optionalEquipamento.get();
            equipamento.setDescricao_equipamento(equipamentoDto.descricao_equipamento());
            equipamento.setTipo_equipamento(equipamentoDto.tipo_equipamento());
            equipamento.setEstoque_atual_equipamento(equipamentoDto.estoque_atual_equipamento());


            equipamentoRepository.save(equipamento); // Salva as alterações no banco de dados
        }

        return "redirect:/visualizacaoEquipamento";
    }

}