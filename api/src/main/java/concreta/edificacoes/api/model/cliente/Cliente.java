package concreta.edificacoes.api.model.cliente;

import concreta.edificacoes.api.dto.cliente.ClienteFisicoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Cliente")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Cliente")
    private Long codigoCliente;
    @NotEmpty
    private String nome_cliente;
    @NotEmpty
    private String cep_cliente;
    @NotEmpty
    private String logradouro_cliente;
    @NotEmpty
    private String numero_cliente;

    private String complemento_cliente;

    @NotEmpty
    private String bairro_cliente;
    @NotEmpty
    private String cidade_cliente;
    @NotEmpty
    private String estado_cliente;
    @NotEmpty
    private String telefone_cliente;
    @NotEmpty
    private String email_cliente;

    public Cliente(ClienteFisicoDto clienteFisicoDto) {
        this.nome_cliente=clienteFisicoDto.nome_cliente();
        this.email_cliente=clienteFisicoDto.email_cliente();
        this.bairro_cliente=clienteFisicoDto.bairro_cliente();
        this.cidade_cliente=clienteFisicoDto.cidade_cliente();
        this.estado_cliente=clienteFisicoDto.estado_cliente();
        this.cep_cliente=clienteFisicoDto.cep_cliente();
        this.complemento_cliente=clienteFisicoDto.complemento_cliente();
        this.logradouro_cliente=clienteFisicoDto.logradouro_cliente();
        this.numero_cliente=clienteFisicoDto.numero_cliente();
        this.telefone_cliente=clienteFisicoDto.telefone_cliente();
    }
}
