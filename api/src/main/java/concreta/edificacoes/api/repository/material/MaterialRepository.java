package concreta.edificacoes.api.repository.material;

import concreta.edificacoes.api.model.material.Material;
import org.springframework.data.repository.CrudRepository;

public interface MaterialRepository extends CrudRepository <Material, String> {
}
