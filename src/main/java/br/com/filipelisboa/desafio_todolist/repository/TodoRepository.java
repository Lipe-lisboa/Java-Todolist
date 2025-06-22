package br.com.filipelisboa.desafio_todolist.repository;


import br.com.filipelisboa.desafio_todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

//                                              entidade e o tipo do id da entidade
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
