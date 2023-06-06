package concreta.edificacoes.api.controller.profissional;

import concreta.edificacoes.api.dto.cliente.ClienteJuridicoDto;
import concreta.edificacoes.api.dto.profissional.ProfissionalDto;
import concreta.edificacoes.api.model.cliente.ClienteJuridico;
import concreta.edificacoes.api.model.profissional.Profissional;
import concreta.edificacoes.api.repository.profissional.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @RequestMapping("/cadastroProfissional")
    private String cadastroProfissional(){
        return "profissional/cadastroProfissional";
    }

    @RequestMapping(value = "/cadastroProfissional", method = RequestMethod.POST)
    public String cadastrarClienteJuridico(ProfissionalDto profissionalDto){

        var profissional = new Profissional(profissionalDto);

        profissionalRepository.save(profissional);

        return "redirect:/cadastroProfissional";
    }

    @RequestMapping("/visualizacaoProfissional")
    private String visualizacaoProfissional(){
        return "profissional/visualizacaoProfissional";
    }

}
