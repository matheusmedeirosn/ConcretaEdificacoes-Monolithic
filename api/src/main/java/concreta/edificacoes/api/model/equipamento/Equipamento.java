package concreta.edificacoes.api.model.equipamento;

import concreta.edificacoes.api.dto.equipamento.EquipamentoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Equipamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento {
    @Id
    @Column(name = "Cod_Equipamento")
    private Long cod_equipamento;
    @Column(name = "Descricao_Equipamento")
    private String descricao_equipamento;
    @Column(name = "Estoque_Atual_Equipamento")
    private Integer estoque_atual_equipamento;
    @Column(name = "Tipo_Equipamento")
    @NotEmpty
    private String tipo_equipamento;
    @Column(name = "Unidade_Fornecimento")
    @NotEmpty
    private String unidade_fornecimento;

    public Equipamento(EquipamentoDto equipamentoDto){
        this.cod_equipamento=equipamentoDto.cod_equipamento();
        this.descricao_equipamento=equipamentoDto.descricao_equipamento();
        this.tipo_equipamento=equipamentoDto.tipo_equipamento();
        this.estoque_atual_equipamento=equipamentoDto.estoque_atual_equipamento();
        this.unidade_fornecimento=equipamentoDto.unidade_fornecimento();
    }

}
