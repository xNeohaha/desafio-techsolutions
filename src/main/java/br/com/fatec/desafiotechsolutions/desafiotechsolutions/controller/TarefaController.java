package br.com.fatec.desafiotechsolutions.desafiotechsolutions.controller;

import br.com.fatec.desafiotechsolutions.desafiotechsolutions.model.Tarefa;
import br.com.fatec.desafiotechsolutions.desafiotechsolutions.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }
    // getall users
    @GetMapping
    public ResponseEntity<List<Tarefa>>listar() {
        return ResponseEntity.ok(tarefaService.listar());
    }
    //getuser by index
    @GetMapping("/{index}")
    public ResponseEntity<Tarefa> buscarPorIndice(@PathVariable int index) {
        Tarefa tarefa = tarefaService.buscarporIndex(index);
        return ResponseEntity.ok(tarefa);
    }


    // post add user
    @PostMapping
    public ResponseEntity<Tarefa> adicionar(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.adicionar(tarefa);
        return ResponseEntity.status(201).body(novaTarefa);
    }
    //put update user
    @PutMapping("/{index}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable int index, @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizar(index,tarefa);
        if (tarefaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefaAtualizada);
    }

    // delete remove user

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> deletar(@PathVariable int index) {
        boolean removido= tarefaService.deletar(index);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
