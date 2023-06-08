package concreta.edificacoes.api.dto.servico;

import java.time.LocalDate;

public record ServicoDto (String descricao_servico, String preco_servico, String tipo_servico,
                         LocalDate data_inicial_servico, LocalDate previsao_termino_servico) {
}
