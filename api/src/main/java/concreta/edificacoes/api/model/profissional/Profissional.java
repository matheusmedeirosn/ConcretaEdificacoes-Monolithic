package concreta.edificacoes.api.model.profissional;

import concreta.edificacoes.api.dto.profissional.ProfissionalDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "Profissional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profissional {

    @Id
    @Column(name = "Matricula_Profissional")
    private Long matricula_profissional;

    @NotEmpty
    @Column(name = "Nome_Profissional")
    private String nome_profissional;

    @NotEmpty
    @Column(name = "CPF_Profissional")
    private String cpf_profissional;

    @NotEmpty
    @Column(name = "Sexo_Profissional")
    private String sexo_profissional;

    @NotEmpty
    @Column(name = "Nascimento_Profissional ")
    private LocalDate nascimento_profissional;

    @NotEmpty
    @Column(name = "Funcao_Profissional")
    private String funcao_profissional;

    @Column(name = "Titulacao")
    private String titulacao;

    public Profissional(ProfissionalDto profissionalDto){
        this.matricula_profissional=profissionalDto.matricula_profissional();
        this.nome_profissional=profissionalDto.nome_profissional();
        this.cpf_profissional=profissionalDto.cpf_profissional();
        this.funcao_profissional=profissionalDto.funcao_profissional();
        this.nascimento_profissional=profissionalDto.nascimento_profissional();
        this.sexo_profissional=profissionalDto.sexo_profissional();
        this.titulacao=profissionalDto.titulacao();
    }
}
