package concreta.edificacoes.api.model.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "Cliente_Fisico")
@Entity(name = "ClienteJuridico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteJuridico {

    private String cnpj;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoCliente;
    private String nomeFantasia;
    private String razaoSocial;
    private Integer Insc_Estadual;

}
