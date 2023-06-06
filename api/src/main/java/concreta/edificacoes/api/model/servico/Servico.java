package concreta.edificacoes.api.model.servico;

import concreta.edificacoes.api.dto.servico.ServicoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "Servico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servico {

    @Id @Column(name = "Cod_Servico")
    private Long cod_servico;

    @Column(name = "Descricao_Servico")
    private String descricao_servico;

    @Column(name = "Preco_Servico")
    private String preco_servico;

    @Column(name = "Tipo_Servico")
    private String tipo_servico;

    @Column(name = "Data_Inicial_Servico ")
    private LocalDate data_inicial_servico;

    @Column(name = "Previsao_Termino_Servico")
    private LocalDate previsao_termino_servico;

    public Servico(ServicoDto servicoDto){
        this.cod_servico=servicoDto.cod_servico();
        this.descricao_servico=servicoDto.descricao_servico();
        this.preco_servico=servicoDto.preco_servico();
        this.tipo_servico=servicoDto.tipo_servico();
        this.data_inicial_servico=servicoDto.data_inicial_servico();
        this.previsao_termino_servico=servicoDto.previsao_termino_servico();
    }

}
