package concreta.edificacoes.api.model.cliente;

import concreta.edificacoes.api.dto.cliente.ClienteJuridicoDto;
import concreta.edificacoes.api.dto.equipamento.EquipamentoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Cliente_Juridico")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "Cod_Cliente")
public class ClienteJuridico extends Cliente{


    private String cnpj_cliente;
    private String nome_fantasia;
    private String razao_social;
    private Integer insc_estadual;

    public ClienteJuridico(ClienteJuridicoDto clienteJuridioDto) {
        super(clienteJuridioDto);
        this.cnpj_cliente=clienteJuridioDto.cnpj_cliente();
        this.nome_fantasia=clienteJuridioDto.nome_fantasia();
        this.razao_social=clienteJuridioDto.razao_social();
        this.insc_estadual= clienteJuridioDto.insc_estadual();
    }
}
