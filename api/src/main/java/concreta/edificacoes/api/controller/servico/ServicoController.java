package concreta.edificacoes.api.controller.servico;

import concreta.edificacoes.api.dto.cliente.ClienteJuridicoDto;
import concreta.edificacoes.api.dto.servico.ServicoDto;
import concreta.edificacoes.api.model.cliente.ClienteJuridico;
import concreta.edificacoes.api.model.servico.Servico;
import concreta.edificacoes.api.repository.servico.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

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

}
