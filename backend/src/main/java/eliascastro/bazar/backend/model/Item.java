package eliascastro.bazar.backend.model;

import eliascastro.bazar.backend.controller.DadosCadastroItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "itens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue()
    private UUID id;

    private String nome;
    private String descricao;
    private Double preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Boolean ativo;

    public Item(DadosCadastroItem dados){
        this.id = UUID.randomUUID();
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.categoria = dados.categoria();
        this.preco = dados.preco();
        this.ativo = true;
    }


}
