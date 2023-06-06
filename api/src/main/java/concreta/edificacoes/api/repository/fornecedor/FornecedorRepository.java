package concreta.edificacoes.api.repository.fornecedor;

import concreta.edificacoes.api.model.fornecedor.Fornecedor;
import org.springframework.data.repository.CrudRepository;

public interface FornecedorRepository extends CrudRepository <Fornecedor, String> {
}
