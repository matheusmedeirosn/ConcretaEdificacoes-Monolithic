package concreta.edificacoes.api.controller.cliente;

import concreta.edificacoes.api.dto.cliente.ClienteFisicoDto;
import concreta.edificacoes.api.dto.cliente.ClienteJuridicoDto;
import concreta.edificacoes.api.model.cliente.ClienteFisico;
import concreta.edificacoes.api.model.cliente.ClienteJuridico;
import concreta.edificacoes.api.repository.cliente.ClienteFisicoRepository;
import concreta.edificacoes.api.repository.cliente.ClienteJuridicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteFisicoRepository clienteFisicoRepository;

    @Autowired
    private ClienteJuridicoRepository clienteJuridicoRepository;

    @RequestMapping("/cadastrarCliente")
    public String cadastroCliente(){
        return "cliente/CadastroCliente";
    }

    @GetMapping("/cadastroClienteFisico")
    public String cadastroClienteFisico(){
        return "cliente/CadastroClienteFisico";
    }

    @RequestMapping(value = "/cadastroClienteFisico", method = RequestMethod.POST)
    public String cadastroClienteFisico(ClienteFisicoDto clienteFisicoDto){

        var cliente = new ClienteFisico(clienteFisicoDto);

        clienteFisicoRepository.save(cliente);

        return "redirect:/cadastroClienteFisico";
    }

    @GetMapping("/cadastroClienteJuridico")
    public String cadastroClienteJuridico(){
        return "cliente/cadastroClienteJuridico";
    }

    @RequestMapping(value = "/cadastroClienteJuridico", method = RequestMethod.POST)
    public String cadastroClienteJuridico(ClienteJuridicoDto clienteJuridicoDto){

        var cliente = new ClienteJuridico(clienteJuridicoDto);

        clienteJuridicoRepository.save(cliente);

        return "redirect:/cadastroClienteJuridico";
    }

    @RequestMapping("/visualizarClientes")
    public String visualizacaoCliente(){
        return "cliente/visualizacaoCliente";
    }

    @RequestMapping("/visualizarClientesJuridicos")
    public String visualizarClienteJuridico(){
        return "cliente/visualizacaoClienteJuridico";
    }

}
