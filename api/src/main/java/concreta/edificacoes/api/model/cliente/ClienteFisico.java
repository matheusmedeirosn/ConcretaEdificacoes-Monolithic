package concreta.edificacoes.api.model.cliente;

import concreta.edificacoes.api.dto.cliente.ClienteFisicoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "Cliente_Fisico")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "Cod_Cliente")
public class ClienteFisico extends Cliente{

    private String cpf_cliente;
    @Column(name = "Nascimento_Cliente")
    private LocalDate dataNascimento_cliente;
    @Column (name = "Sexo_Cliente")
    private String sexo_cliente;

    public ClienteFisico(ClienteFisicoDto clienteFisicoDto) {
        super(clienteFisicoDto);
        this.cpf_cliente=clienteFisicoDto.cpf_cliente();
        this.sexo_cliente=clienteFisicoDto.sexo_cliente();
        this.dataNascimento_cliente=clienteFisicoDto.dataNascimento_cliente();
    }
}
