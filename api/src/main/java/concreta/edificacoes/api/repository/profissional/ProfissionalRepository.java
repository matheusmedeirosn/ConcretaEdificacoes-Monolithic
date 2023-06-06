package concreta.edificacoes.api.repository.profissional;

import concreta.edificacoes.api.model.profissional.Profissional;
import org.springframework.data.repository.CrudRepository;

public interface ProfissionalRepository extends CrudRepository <Profissional, String> {
}
