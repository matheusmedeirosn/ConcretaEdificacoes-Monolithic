package concreta.edificacoes.api.controller.projeto;

import concreta.edificacoes.api.dto.cliente.ClienteJuridicoDto;
import concreta.edificacoes.api.dto.projeto.ProjetoDto;
import concreta.edificacoes.api.model.cliente.ClienteJuridico;
import concreta.edificacoes.api.model.projeto.Projeto;
import concreta.edificacoes.api.repository.projeto.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping("/cadastroProjeto")
    private String cadastroProjeto(){
        return "projeto/cadastroProjeto";
    }

    @RequestMapping(value = "/cadastroProjeto", method = RequestMethod.POST)
    public String cadastroProjeto(ProjetoDto projetoDto){

        var projeto = new Projeto(projetoDto);

        projetoRepository.save(projeto);

        return "redirect:/cadastroProjeto";
    }
}
