package concreta.edificacoes.api.dto.cliente;

import java.time.LocalDate;
import java.util.Date;

public record ClienteFisicoDto(String nome_cliente, String cep_cliente, String logradouro_cliente , String numero_cliente ,
                               String complemento_cliente, String bairro_cliente, String cidade_cliente,
                               String estado_cliente, String telefone_cliente, String email_cliente, String cpf_cliente,
                               LocalDate dataNascimento_cliente, String sexo_cliente) {
}
