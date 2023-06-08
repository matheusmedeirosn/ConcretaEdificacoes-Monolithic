package concreta.edificacoes.api.service;

import concreta.edificacoes.api.model.profissional.Profissional;
import concreta.edificacoes.api.repository.profissional.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    @Autowired
    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository= profissionalRepository;
    }

    public List<Profissional> listarProfissional() {
        // Utilize o equipamentoRepository para buscar os equipamentos no banco de dados
        return (List<Profissional>) profissionalRepository.findAll();
    }

}
