package br.com.fatec.desafiotechsolutions.desafiotechsolutions.service;

import br.com.fatec.desafiotechsolutions.desafiotechsolutions.model.Tarefa;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class TarefaService {
    private final ArrayList<Tarefa> listaTarefas = new ArrayList<>();

    public List<Tarefa> listar() {
        return listaTarefas;
    }

    // buscar por index
    public Tarefa buscarporIndex(int index) {
        if (index < 0 || index >= listaTarefas.size()) {
            return null;
        }
        return listaTarefas.get(index);
    }
    // adicionar

    public Tarefa adicionar(Tarefa tarefa) {
        listaTarefas.add(tarefa);
        return tarefa;
    }

    //atualizar
    public Tarefa atualizar(int index, Tarefa tarefa) {
        if (index < 0 || index >= listaTarefas.size()) {
            return null;
        }
        listaTarefas.set(index,tarefa);
        return tarefa;
    }
    // delete
    public boolean deletar(int index) {
        if (index < 0 || index >= listaTarefas.size()) {
            return false;
        }
        listaTarefas.remove(index);
        return true;

    }
}
