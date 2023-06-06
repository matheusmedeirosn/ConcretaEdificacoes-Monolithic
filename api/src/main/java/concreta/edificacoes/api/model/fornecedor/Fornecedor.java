package concreta.edificacoes.api.model.fornecedor;

import concreta.edificacoes.api.dto.fornecedor.FornecedorDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Fornecedor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {

    @Id @Column(name = "CNPJ_Fornecedor")
    private String cnpj_fornecedor;
    @Column(name = "Nome_Fantasia")
    @NotEmpty
    private String nome_fantasia;
    @Column (name = "Razao_Social")
    private String razao_social;
    @Column(name = "Telefone_Fornecedor")
    private String telefone_fornecedor;
    @Column(name = "Contato_Fornecedor")
    private String contato_fornecedor;
    @Column(name = "CEP_Fornecedor")
    @NotEmpty
    private String cep_fornecedor;
    @Column(name = "Logradouro_Fornecedor")
    private String logradouro_fornecedor;
    @Column(name = "Numero_Fornecedor")
    @NotEmpty
    private String numero_fornecedor;
    @Column(name = "Complemento_Fornecedor")
    private String complemento_fornecedor;
    @Column(name = "Bairro_Fornecedor")
    private String bairro_fornecedor;
    @Column(name = "Cidade_Fornecedor")
    @NotEmpty
    private String cidade_fornecedor;
    @Column(name = "Estado_Fornecedor")
    @NotEmpty
    private String estado_fornecedor;
    @Column(name = "Descricao_Fornecedor")
    private String descricao_fornecedor;

    public Fornecedor (FornecedorDto fornecedorDto){
        this.cnpj_fornecedor=fornecedorDto.cnpj_fornecedor();
        this.nome_fantasia=fornecedorDto.nome_fantasia();
        this.razao_social=fornecedorDto.razao_social();
        this.telefone_fornecedor=fornecedorDto.telefone_fornecedor();
        this.contato_fornecedor=fornecedorDto.contato_fornecedor();
        this.cep_fornecedor=fornecedorDto.cep_fornecedor();
        this.logradouro_fornecedor=fornecedorDto.logradouro_fornecedor();
        this.numero_fornecedor=fornecedorDto.numero_fornecedor();
        this.complemento_fornecedor=fornecedorDto.complemento_fornecedor();
        this.bairro_fornecedor=fornecedorDto.bairro_fornecedor();
        this.cidade_fornecedor=fornecedorDto.cidade_fornecedor();
        this.estado_fornecedor=fornecedorDto.estado_fornecedor();
        this.descricao_fornecedor=fornecedorDto.descricao_fornecedor();
    }

}
