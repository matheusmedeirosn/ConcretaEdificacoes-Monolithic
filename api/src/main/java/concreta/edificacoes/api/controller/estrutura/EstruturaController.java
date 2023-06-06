package concreta.edificacoes.api.controller.estrutura;

import concreta.edificacoes.api.dto.equipamento.EquipamentoDto;
import concreta.edificacoes.api.dto.estrutura.EstruturaDto;
import concreta.edificacoes.api.model.equipamento.Equipamento;
import concreta.edificacoes.api.model.estrutura.Estrutura;
import concreta.edificacoes.api.repository.equipamento.EquipamentoRepository;
import concreta.edificacoes.api.repository.estrutura.EstruturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EstruturaController {

    @Autowired
    private EstruturaRepository estruturaRepository;

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

}
