package concreta.edificacoes.api.repository.cliente;

import concreta.edificacoes.api.model.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository <Cliente, String> {
}
