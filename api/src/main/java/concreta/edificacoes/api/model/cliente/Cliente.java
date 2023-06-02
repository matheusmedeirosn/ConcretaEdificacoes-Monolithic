package concreta.edificacoes.api.model.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "Cliente")
@Entity(name = "Cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "Cod_Cliente")
    private Long codigoCliente;
    private String nome;
    private String cep;
    private String logradouro;
    private Integer numeroResidencia;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String email;

}
