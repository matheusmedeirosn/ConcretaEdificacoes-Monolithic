package concreta.edificacoes.api.dto.projeto;

import java.time.LocalDate;

public record ProjetoDto(String descricao, String engenheiro_responsavel, LocalDate data_inicial,
                         LocalDate previsao_entrega, String cep_projeto, String logradouro_projeto,
                         Integer numero_projeto, String bairro_projeto, String cidade_projeto, String estado_projeto, String complemento_projeto) {
}
