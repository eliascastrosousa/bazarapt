package eliascastro.bazar.backend.controller;

import eliascastro.bazar.backend.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemService {

    @Autowired
    private ItemRepository repository;

    public DadosCadastroItem cadastrar(DadosCadastroItem dados) {
        var item = new Item(dados);
        repository.save(item);
        return converteDados(item);
    }
}
