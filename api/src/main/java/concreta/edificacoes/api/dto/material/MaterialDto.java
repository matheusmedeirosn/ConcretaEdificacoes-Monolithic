package concreta.edificacoes.api.dto.material;

public record MaterialDto(Long cod_material, String descricao_material, String unidade_medida,Integer estoque_minimo_material,
                          Integer estoque_atual_material,String unidade_fornecimento_material) {
}
