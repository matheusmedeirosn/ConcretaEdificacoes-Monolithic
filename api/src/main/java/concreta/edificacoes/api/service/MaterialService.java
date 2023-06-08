package concreta.edificacoes.api.service;

import concreta.edificacoes.api.model.material.Material;
import concreta.edificacoes.api.repository.material.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository= materialRepository;
    }

    public List<Material> listarMaterial() {
        // Utilize o equipamentoRepository para buscar os equipamentos no banco de dados
        return (List<Material>) materialRepository.findAll();
    }

}
