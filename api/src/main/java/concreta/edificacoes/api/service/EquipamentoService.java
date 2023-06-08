package concreta.edificacoes.api.service;

import concreta.edificacoes.api.model.equipamento.Equipamento;
import concreta.edificacoes.api.repository.equipamento.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    @Autowired
    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<Equipamento> listarEquipamentos() {
        // Utilize o equipamentoRepository para buscar os equipamentos no banco de dados
        return (List<Equipamento>) equipamentoRepository.findAll();
    }

}
