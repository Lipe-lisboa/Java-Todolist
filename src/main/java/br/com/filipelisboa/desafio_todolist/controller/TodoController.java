package br.com.filipelisboa.desafio_todolist.controller;


import br.com.filipelisboa.desafio_todolist.entity.Todo;
import br.com.filipelisboa.desafio_todolist.service.TodoService;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    List<Todo> list(){
        return todoService.list();
    }

    List<Todo> create(Todo todo){
        return todoService.create(todo);
    }

    List<Todo> update(Todo todo){
        return todoService.update(todo);
    }

    List<Todo> delete(long id){
        return todoService.delete(id);
    }
}
