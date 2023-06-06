package concreta.edificacoes.api.model.estrutura;

import concreta.edificacoes.api.dto.estrutura.EstruturaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Estrutura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estrutura {

    @Id
    @Column(name = "Cod_Estrutura")
    private Long cod_estrutura;

    @Column(name = "Descricao_Estrutura")
    private String descricao_estrutura;

    @Column(name = "Estoque_Min_Estrutura")
    @NotEmpty
    private String estoque_min_estrutura;

    @Column(name = "Estoque_Max_Estrutura")
    @NotEmpty
    private String estoque_max_estrutura;

    public Estrutura(EstruturaDto estruturaDto){
        this.cod_estrutura=estruturaDto.cod_estrutura();
        this.estoque_max_estrutura=estruturaDto.estoque_max_estrutura();
        this.estoque_min_estrutura=estruturaDto.estoque_min_estrutura();
        this.descricao_estrutura=estruturaDto.descricao_estrutura();
    }

}
