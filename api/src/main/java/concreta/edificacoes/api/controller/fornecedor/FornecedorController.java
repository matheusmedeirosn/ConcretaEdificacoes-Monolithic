package concreta.edificacoes.api.controller.fornecedor;

import concreta.edificacoes.api.dto.fornecedor.FornecedorDto;
import concreta.edificacoes.api.dto.fornecedor.FornecedorDto;
import concreta.edificacoes.api.model.fornecedor.Fornecedor;
import concreta.edificacoes.api.model.fornecedor.Fornecedor;
import concreta.edificacoes.api.repository.fornecedor.FornecedorRepository;
import concreta.edificacoes.api.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/editarFornecedor/{cnpjFornecedor}", method = RequestMethod.GET)
    public String editarFornecedor(@PathVariable("cnpjFornecedor") Long cnpjFornecedor, Model model) {
        Optional<Fornecedor> optionalFornecedor = fornecedorRepository.findById(String.valueOf(cnpjFornecedor));

        if (optionalFornecedor.isPresent()) {
            Fornecedor fornecedor = optionalFornecedor.get();
            model.addAttribute("fornecedor", fornecedor);
            // Redireciona para a página de edição
            return "fornecedor/editarFornecedor";
        } else {
            // Fornecedor não encontrado, redireciona para algum lugar apropriado
            return "redirect:/visualizacaoFornecedor";
        }
    }

    @PostMapping("/salvarFornecedor")
    public String salvarFornecedor(@RequestParam("cnpj_fornecedor") String cnpjFornecedor, FornecedorDto fornecedorDto) {
        Optional<Fornecedor> optionalFornecedor = fornecedorRepository.findById(cnpjFornecedor);

        if (optionalFornecedor.isPresent()) {
            Fornecedor fornecedor = optionalFornecedor.get();
            fornecedor.setDescricao_fornecedor(fornecedorDto.descricao_fornecedor());
            fornecedor.setBairro_fornecedor(fornecedorDto.bairro_fornecedor());
            fornecedor.setCidade_fornecedor(fornecedorDto.cidade_fornecedor());
            fornecedor.setEstado_fornecedor(fornecedorDto.estado_fornecedor());
            fornecedor.setCep_fornecedor(fornecedorDto.cep_fornecedor());
            fornecedor.setNome_fantasia(fornecedorDto.nome_fantasia());
            fornecedorRepository.save(fornecedor);
        }

        return "redirect:/visualizacaoFornecedor";
    }


}
