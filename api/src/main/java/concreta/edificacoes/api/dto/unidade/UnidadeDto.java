package concreta.edificacoes.api.dto.unidade;

public record UnidadeDto(Long cod_unidade,Long cod_cliente,Long cod_projeto,String descricao_unidade,String cep_unidade,
                         String logradouro_unidade,Integer numero_unidade,String complemento_unidade,String bairro_unidade,
                         String cidade_unidade,String estado_unidade) {
}
