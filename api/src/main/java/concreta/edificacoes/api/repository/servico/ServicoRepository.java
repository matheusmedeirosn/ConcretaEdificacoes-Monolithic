package concreta.edificacoes.api.repository.servico;

import concreta.edificacoes.api.model.servico.Servico;
import org.springframework.data.repository.CrudRepository;

public interface ServicoRepository extends CrudRepository <Servico, String> {
}
