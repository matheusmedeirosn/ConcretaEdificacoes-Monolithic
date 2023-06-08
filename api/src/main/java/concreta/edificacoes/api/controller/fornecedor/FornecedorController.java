package concreta.edificacoes.api.controller.fornecedor;

import concreta.edificacoes.api.dto.fornecedor.FornecedorDto;
import concreta.edificacoes.api.model.fornecedor.Fornecedor;
import concreta.edificacoes.api.repository.fornecedor.FornecedorRepository;
import concreta.edificacoes.api.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

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
    public String listarFornecedors(Model model) {
        // Obtém a lista de fornecedors do serviço
        List<Fornecedor> fornecedores = fornecedorService.listarFornecedor();
        // Adiciona a lista de fornecedors ao modelo para ser usada na página HTML
        model.addAttribute("fornecedores", fornecedores);
        // Retorna o nome da página HTML para ser exibida
        return "fornecedor/visualizacaoFornecedor";
    }

    @RequestMapping(value = "/excluirFornecedor/{cnpjFornecedor}", method = RequestMethod.GET)
    public String excluirFornecedor(@PathVariable("cnpjFornecedor") String cnpjFornecedor) {
        fornecedorRepository.deleteById(cnpjFornecedor.trim());
        return "redirect:/visualizacaoFornecedor";
    }

}
