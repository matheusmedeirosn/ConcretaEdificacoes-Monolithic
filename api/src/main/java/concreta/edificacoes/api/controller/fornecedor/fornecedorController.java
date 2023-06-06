package concreta.edificacoes.api.controller.fornecedor;

import concreta.edificacoes.api.dto.cliente.ClienteJuridicoDto;
import concreta.edificacoes.api.dto.fornecedor.FornecedorDto;
import concreta.edificacoes.api.model.cliente.ClienteJuridico;
import concreta.edificacoes.api.model.fornecedor.Fornecedor;
import concreta.edificacoes.api.repository.fornecedor.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class fornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping("/cadastroFornecedor")
    private String cadastroFornecedor(){
        return "fornecedor/cadastroFornecedor";
    }

    @RequestMapping(value = "/cadastroFornecedor", method = RequestMethod.POST)
    public String cadastroFornecedor(FornecedorDto fornecedorDto){

        var fornecedor = new Fornecedor(fornecedorDto);

        fornecedorRepository.save(fornecedor);

        return "redirect:/cadastroFornecedor";
    }

    @RequestMapping("/visualizacaoFornecedor")
    private String visualizacaoFornecedor(){
        return "fornecedor/visualizacaoFornecedor";
    }

}
