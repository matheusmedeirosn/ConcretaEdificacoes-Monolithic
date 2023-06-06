package concreta.edificacoes.api.dto.cliente;

public record ClienteJuridicoDto(String nome_cliente, String cep_cliente, String logradouro_cliente , String numero_cliente ,
                                 String complemento_cliente, String bairro_cliente, String cidade_cliente,
                                 String estado_cliente, String telefone_cliente, String email_cliente, String cnpj_cliente, Long cod_cliente,
                                 String nome_fantasia, String razao_social, Integer insc_estadual) {
}
