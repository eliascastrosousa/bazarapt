package eliascastro.bazar.backend.controller;

import eliascastro.bazar.backend.model.Categoria;
import eliascastro.bazar.backend.model.Item;

public record DadosCadastroItem(
        String nome,
        String descricao,
        Categoria categoria,
        Double preco

) {

}
