package concreta.edificacoes.api.repository.unidade;

import concreta.edificacoes.api.model.unidade.Unidade;
import org.springframework.data.repository.CrudRepository;

public interface UnidadeRepository extends CrudRepository <Unidade, String> {
}
