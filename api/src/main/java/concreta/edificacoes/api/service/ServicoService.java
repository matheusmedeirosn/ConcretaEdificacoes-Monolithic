package concreta.edificacoes.api.service;

import concreta.edificacoes.api.model.servico.Servico;
import concreta.edificacoes.api.repository.servico.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository= servicoRepository;
    }

    public List<Servico> listarServico() {
        // Utilize o equipamentoRepository para buscar os equipamentos no banco de dados
        return (List<Servico>) servicoRepository.findAll();
    }

}
