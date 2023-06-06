package concreta.edificacoes.api.repository.projeto;

import concreta.edificacoes.api.model.projeto.Projeto;
import org.springframework.data.repository.CrudRepository;

public interface ProjetoRepository extends CrudRepository <Projeto, String> {
}
