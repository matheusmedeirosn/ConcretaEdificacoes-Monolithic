package concreta.edificacoes.api.service;

import concreta.edificacoes.api.model.unidade.Unidade;
import concreta.edificacoes.api.repository.unidade.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    @Autowired
    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository= unidadeRepository;
    }

    public List<Unidade> listarUnidade() {
        // Utilize o equipamentoRepository para buscar os equipamentos no banco de dados
        return (List<Unidade>) unidadeRepository.findAll();
    }

}
