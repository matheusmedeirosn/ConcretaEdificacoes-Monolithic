package concreta.edificacoes.api.service;

import concreta.edificacoes.api.model.projeto.Projeto;
import concreta.edificacoes.api.repository.projeto.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository= projetoRepository;
    }

    public List<Projeto> listarProjeto() {
        // Utilize o equipamentoRepository para buscar os equipamentos no banco de dados
        return (List<Projeto>) projetoRepository.findAll();
    }

}
