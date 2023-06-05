package concreta.edificacoes.api.model.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Cliente_Juridico")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "codigoCliente")
public class ClienteJuridico extends Cliente{

    private String cnpj;
    @Id
    @JoinColumn(name = "Cod_Cliente")
    private Long codigoCliente;
    private String nomeFantasia;
    private String razaoSocial;
    private Integer Insc_Estadual;

}
