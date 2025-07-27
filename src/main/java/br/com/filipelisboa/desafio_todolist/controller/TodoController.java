package br.com.filipelisboa.desafio_todolist.controller;


import br.com.filipelisboa.desafio_todolist.entity.Todo;
import br.com.filipelisboa.desafio_todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos") //http://localhost:8080/todos
public class TodoController {

    // Serviço da nossa aplicação
    private TodoService todoService;

    public TodoController(TodoService todoService) {

        this.todoService = todoService;
    }

    // Expecificando o local de onde irei pegar cada valor
    // @RequestBody Todo todo
    // @PathVariable(value = "id")

    // Metodo http da rota é GET
    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }

    // Metodo http da rota é POST
    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo){
        return todoService.create(todo);
    }

    // Metodo http da rota é PUT (UPDATE)
    @PutMapping
    List<Todo> update(@RequestBody @Valid Todo todo){
        return todoService.update(todo);
    }

    // Metodo http da rota é DELETE
    @DeleteMapping("{id}") // Pego a variavel da rota http (id)
    List<Todo> delete(@PathVariable(value = "id") long id){
        return todoService.delete(id);
    }
}
