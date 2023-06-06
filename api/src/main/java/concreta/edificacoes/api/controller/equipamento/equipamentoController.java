package concreta.edificacoes.api.controller.equipamento;

import concreta.edificacoes.api.dto.cliente.ClienteJuridicoDto;
import concreta.edificacoes.api.dto.equipamento.EquipamentoDto;
import concreta.edificacoes.api.model.cliente.ClienteJuridico;
import concreta.edificacoes.api.model.equipamento.Equipamento;
import concreta.edificacoes.api.repository.equipamento.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class equipamentoController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @GetMapping("/cadastroEquipamento")
    private String cadastroEquipamento(){
        return "equipamento/cadastroEquipamento";
    }

    @RequestMapping(value = "/cadastroEquipamento", method = RequestMethod.POST)
    public String cadastroEquipamento(EquipamentoDto equipamentoDto){

        var equipamento = new Equipamento(equipamentoDto);

        equipamentoRepository.save(equipamento);

        return "redirect:/cadastroEquipamento";
    }

    @RequestMapping("visualizacaoEquipamento")
    private String visualizacaoEquipamento(){
        return "equipamento/visualizacaoEquipamento";
    }
}
