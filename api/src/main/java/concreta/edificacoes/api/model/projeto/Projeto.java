package concreta.edificacoes.api.model.projeto;

import concreta.edificacoes.api.dto.projeto.ProjetoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "Projeto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {

    @Id
    @Column(name = "Cod_Projeto")
    private Long cod_projeto;

    @Column(name = "Descricao")
    private String descricao;

    @Column(name = "Engenheiro_Responsavel")
    private String engenheiro_responsavel;

    @Column(name = "Data_Inicial")
    private LocalDate data_inicial;

    @Column(name = "Previsao_Entrega")
    private  LocalDate previsao_entrega;

    @Column(name = "CEP_Projeto")
    private String cep_projeto;

    @Column(name = "Logradouro_Projeto")
    private String logradouro_projeto;

    @Column(name = "Numero_Projeto")
    private Integer numero_projeto;

    @Column(name = "Complemento_Projeto")
    private String complemento_projeto;

    @Column(name = "Bairro_Projeto")
    private String bairro_projeto;

    @Column(name = "Cidade_Projeto")
    private String cidade_projeto;

    @Column(name = "Estado_Projeto")
    private String estado_projeto;

    public Projeto(ProjetoDto projetoDto){
        this.cod_projeto=projetoDto.cod_projeto();
        this.descricao=projetoDto.descricao();
        this.engenheiro_responsavel=projetoDto.engenheiro_responsavel();
        this.bairro_projeto=projetoDto.bairro_projeto();
        this.cep_projeto=projetoDto.cep_projeto();
        this.cidade_projeto=projetoDto.cidade_projeto();
        this.estado_projeto=projetoDto.estado_projeto();
        this.data_inicial=projetoDto.data_inicial();
        this.previsao_entrega=projetoDto.previsao_entrega();
        this.numero_projeto=projetoDto.numero_projeto();
        this.logradouro_projeto=projetoDto.logradouro_projeto();
        this.complemento_projeto=projetoDto.complemento_projeto();
    }

}
