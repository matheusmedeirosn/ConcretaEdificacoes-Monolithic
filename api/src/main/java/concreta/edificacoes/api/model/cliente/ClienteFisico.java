package concreta.edificacoes.api.model.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name= "Cliente_Fisico")
@Entity(name = "ClienteFisico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteFisico {

    private Cliente clientes;
    private String cpf;
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long codigoCliente;
    private Date dataNascimento;
    private String sexo;


}
