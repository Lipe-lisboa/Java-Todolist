package br.com.filipelisboa.desafio_todolist.repository;

//Um repositório é uma camada de abstração que permite interagir com o banco de dados.
// No contexto da sua aplicação Spring Boot, a classe TodoRepository é uma interface que
// estende JpaRepository.


//Em termos simples, a TodoRepository fornece um conjunto de métodos prontos para você
// realizar operações comuns de banco de dados (CRUD - Criar, Ler, Atualizar e Deletar)
// na sua entidade.

import br.com.filipelisboa.desafio_todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

//                                              entidade e o tipo do id da entidade
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
