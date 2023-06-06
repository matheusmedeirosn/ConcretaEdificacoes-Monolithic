package concreta.edificacoes.api.dto.profissional;

import java.time.LocalDate;

public record ProfissionalDto(Long matricula_profissional,String nome_profissional, String cpf_profissional, String sexo_profissional,
                              LocalDate nascimento_profissional,String funcao_profissional,String titulacao) {
}
