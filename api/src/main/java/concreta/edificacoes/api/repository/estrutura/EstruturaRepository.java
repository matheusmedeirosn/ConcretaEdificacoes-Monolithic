package concreta.edificacoes.api.repository.estrutura;

import concreta.edificacoes.api.model.estrutura.Estrutura;
import org.springframework.data.repository.CrudRepository;

public interface EstruturaRepository extends CrudRepository <Estrutura, String> {
}
