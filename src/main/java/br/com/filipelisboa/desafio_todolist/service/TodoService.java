package br.com.filipelisboa.desafio_todolist.service;


import br.com.filipelisboa.desafio_todolist.entity.Todo;
import br.com.filipelisboa.desafio_todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    // repositorio da nossa entidade (tabela Todo)
    // nome da var -> todoRepository
    // tipo da var -> TodoRepository
    private TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository) {

        this.todoRepository = todoRepository;
    }


    public List<Todo> list(){

        //ordenando por prioridades decrecente
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );
        return todoRepository.findAll(sort);
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);

        return list();
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);

        return list();
    }

    public List<Todo> delete(Long id){

        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return list();
        }else { // Captura sua exceção customizada se o Todo não for encontrado
            throw new NoSuchElementException("Todo não encontrado com ID: " + id); // Lança NoSuchElementException
        }
    }


}
