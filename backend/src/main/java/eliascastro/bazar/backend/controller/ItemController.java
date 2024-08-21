package eliascastro.bazar.backend.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("itens")
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroItem dados, UriComponentsBuilder uriBuilder){
        var item = service.cadastrar(dados);
        var uri = uriBuilder.path("/itens/{id}").buildAndExpand(item).toUri();
        return ResponseEntity.created(uri).body(item);
    }

    @GetMapping
    public ResponseEntity<List<DadosCadastroAluno>> listar(@PageableDefault(size = 10, sort = {"nome"})  Pageable paginacao) {
        var page = alunoService.listarTodos(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{cpf}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable String cpf, @RequestBody @Valid DadosAtualizacaoAluno dados){
        var aluno = alunoService.atualizarAluno(dados, cpf);
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity detalhamento(@PathVariable String cpf) {
        var aluno = alunoService.detalharAluno(cpf);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public ResponseEntity excluir(@PathVariable String cpf){
        alunoService.desativarAluno(cpf);
        return ResponseEntity.notFound().build();
    }
}
