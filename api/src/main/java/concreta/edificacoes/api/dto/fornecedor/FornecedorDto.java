package concreta.edificacoes.api.dto.fornecedor;

public record FornecedorDto(String cnpj_fornecedor,String nome_fantasia,String razao_social,String telefone_fornecedor,
                            String contato_fornecedor,String cep_fornecedor,String logradouro_fornecedor,
                            String numero_fornecedor,String complemento_fornecedor,String bairro_fornecedor,
                            String cidade_fornecedor,String estado_fornecedor, String descricao_fornecedor) {
}
