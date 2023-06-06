package concreta.edificacoes.api.repository.equipamento;

import concreta.edificacoes.api.model.equipamento.Equipamento;
import org.springframework.data.repository.CrudRepository;

public interface EquipamentoRepository extends CrudRepository<Equipamento, String> {
}
