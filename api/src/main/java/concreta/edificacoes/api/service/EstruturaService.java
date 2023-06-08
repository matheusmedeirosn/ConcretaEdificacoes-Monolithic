package concreta.edificacoes.api.service;

import concreta.edificacoes.api.model.equipamento.Equipamento;
import concreta.edificacoes.api.model.estrutura.Estrutura;
import concreta.edificacoes.api.repository.equipamento.EquipamentoRepository;
import concreta.edificacoes.api.repository.estrutura.EstruturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstruturaService {

    private final EstruturaRepository estruturaRepository;

    @Autowired
    public EstruturaService(EstruturaRepository estruturaRepository) {
        this.estruturaRepository= estruturaRepository;
    }

    public List<Estrutura> listarEstrutura() {
        // Utilize o equipamentoRepository para buscar os equipamentos no banco de dados
        return (List<Estrutura>) estruturaRepository.findAll();
    }

}
