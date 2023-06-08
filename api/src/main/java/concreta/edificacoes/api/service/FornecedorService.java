package concreta.edificacoes.api.service;

import concreta.edificacoes.api.model.fornecedor.Fornecedor;
import concreta.edificacoes.api.repository.fornecedor.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository= fornecedorRepository;
    }

    public List<Fornecedor> listarFornecedor() {
        // Utilize o equipamentoRepository para buscar os equipamentos no banco de dados
        return (List<Fornecedor>) fornecedorRepository.findAll();
    }
    
}
