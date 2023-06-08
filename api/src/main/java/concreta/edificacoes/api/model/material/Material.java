package concreta.edificacoes.api.model.material;

import concreta.edificacoes.api.dto.material.MaterialDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Material")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Material {

    @Id @Column(name = "Cod_Material")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_material;

    @Column(name = "Descricao_Material")
    private String descricao_material;

    @Column(name = "Unidade_Medida")
    @NotEmpty
    private String unidade_medida;

    @Column(name = "Estoque_Minimo_Material")
    private Integer estoque_minimo_material;

    @Column(name = "Estoque_Atual_Material")
    private Integer estoque_atual_material;

    @Column (name = "Unidade_Fornecimento_Material")
    private String unidade_fornecimento_material;

    public Material (MaterialDto materialDto){
        this.estoque_atual_material=materialDto.estoque_atual_material();
        this.descricao_material=materialDto.descricao_material();
        this.unidade_fornecimento_material=materialDto.unidade_fornecimento_material();
        this.estoque_minimo_material=materialDto.estoque_minimo_material();
        this.unidade_medida=materialDto.unidade_medida();
    }

}
