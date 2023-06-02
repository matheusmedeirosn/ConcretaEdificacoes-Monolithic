package concreta.edificacoes.api.controller.cliente;

import concreta.edificacoes.api.model.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {

    @RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
    public String cadastroCliente(){
        return "cliente/CadastroCliente";
    }

    @RequestMapping("/cadastrarClienteFisico")
    public String cadastroClienteFisico(){
        return "cliente/CadastroClienteFisico";
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
