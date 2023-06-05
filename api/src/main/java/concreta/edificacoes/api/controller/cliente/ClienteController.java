package concreta.edificacoes.api.controller.cliente;

import concreta.edificacoes.api.dto.cliente.ClienteFisicoDto;
import concreta.edificacoes.api.model.cliente.Cliente;
import concreta.edificacoes.api.model.cliente.ClienteFisico;
import concreta.edificacoes.api.repository.ClienteFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {

    @Autowired
    private ClienteFisicoRepository clienteFisicoRepository;

    @RequestMapping("/cadastrarCliente")
    public String cadastroCliente(){
        return "cliente/CadastroCliente";
    }

    @GetMapping("/cadastrarClienteFisico")
    public String cadastroClienteFisico(){
        return "cliente/CadastroClienteFisico";
    }

    @RequestMapping(value = "/cadastrarClienteFisico", method = RequestMethod.POST)
    public String cadastroClienteFisico(ClienteFisicoDto clienteFisicoDto){

        var cliente = new ClienteFisico(clienteFisicoDto);

        clienteFisicoRepository.save(cliente);

        return "redirect:/cadastrarClienteFisico";
    }

    @RequestMapping("/cadastrarClienteJuridico")
    public String cadastrarClienteJuridico(){
        return "cliente/cadastroClienteJuridico";
    }

    @RequestMapping("/visualizarClientes")
    public String visualizacaoCliente(){
        return "cliente/visualizacaoCliente";
    }

    @RequestMapping("/visualizarClientesJuridicos")
    public String visualizarClienteJuridico(){
        return "cliente/visualizacaoClienteJuridico";
    }

    @RequestMapping("/visualizarClientesFisicos")
    public String visualizarClienteFisico(){
        return "cliente/visualizacaoClienteFisico";
    }


}
