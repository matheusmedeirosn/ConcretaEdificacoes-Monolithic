    package concreta.edificacoes.api.model.unidade;

    import concreta.edificacoes.api.dto.unidade.UnidadeDto;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    @Entity(name = "Unidade")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Unidade {

        @Id
        @Column(name = "Cod_Unidade ")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long cod_unidade;

        @Column(name = "Cod_Cliente")
        private Long cod_cliente;

        @Column(name = "Cod_Projeto")
        private  Long cod_projeto;

        @Column(name = "Descricao_Unidade")
        private String descricao_unidade;

        @Column(name = "CEP_Unidade")
        private String cep_unidade;

        @Column(name = "Logradouro_Unidade")
        private String logradouro_unidade;

        @Column(name = "Numero_Unidade")
        private Integer numero_unidade;

        @Column(name = "Complemento_Unidade")
        private String complemento_unidade;

        @Column(name = "Bairro_Unidade")
        private String bairro_unidade;

        @Column(name = "Cidade_Unidade")
        private String cidade_unidade;

        @Column(name = "Estado_Unidade")
        private String estado_unidade;

        public Unidade(UnidadeDto unidadeDto){
            this.cod_unidade=unidadeDto.cod_unidade();
            this.cod_cliente=unidadeDto.cod_cliente();
            this.cod_projeto=unidadeDto.cod_projeto();
            this.cidade_unidade=unidadeDto.cidade_unidade();
            this.bairro_unidade=unidadeDto.bairro_unidade();
            this.complemento_unidade=unidadeDto.complemento_unidade();
            this.estado_unidade=unidadeDto.estado_unidade();
            this.descricao_unidade=unidadeDto.descricao_unidade();
            this.cep_unidade=unidadeDto.cep_unidade();
            this.logradouro_unidade=unidadeDto.logradouro_unidade();
            this.numero_unidade=unidadeDto.numero_unidade();
        }

    }
