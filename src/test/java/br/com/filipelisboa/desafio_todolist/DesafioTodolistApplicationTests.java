package br.com.filipelisboa.desafio_todolist;

import br.com.filipelisboa.desafio_todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

//A classe DesafioTodolistApplicationTests é uma classe de teste. Ela serve para verificar
// se as funcionalidades da sua aplicação estão funcionando corretamente em um ambiente próximo ao real.
//Nesse caso específico, o objetivo é testar a criação de um "Todo" (item de lista de tarefas).
// A linha var todo = new Todo("todo1", "desc todo1", false, 7); está apenas criando uma instância
//  de um objeto Todo com alguns dados de exemplo.

//O WebTestClient é uma ferramenta do Spring que permite que você faça requisições HTTP
// para sua própria aplicação Spring Boot durante os testes. Pense nele como um "cliente web"
// que pode interagir com os endpoints da sua API como se fosse um navegador ou outra aplicação
// externa.
//
//Com ele, você pode:
//Enviar requisições GET, POST, PUT, DELETE, etc.
//Verificar os códigos de status HTTP (200 OK, 404 Not Found, etc.).
//Acessar o corpo da resposta (JSON, XML, etc.).
//Validar cabeçalhos, cookies e outros aspectos da comunicação HTTP.


//@Autowired
//O @Autowired é uma anotação do Spring que realiza a injeção de dependência.
// Basicamente, ela diz ao Spring: "Por favor, encontre uma instância de WebTestClient e
// a injete (coloque) nesta variável webTestClient para mim".


// o teste ira rodar em uma porta aleatoria
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {

	// Os testes nem sempre são executados na sequencia

	@Autowired
	private WebTestClient webTestClient;
	@Test
	void TestCreateTodoSuccess() {
		var todo = new Todo("todo1", "desc todo1", false, 7);

		webTestClient
				.post()//metodo
				.uri("/todos") //url
				.bodyValue(todo)//valor escrito no body pelo webCliente
				.exchange() //realiza a requisição
				.expectStatus().isOk() //expectativa do resultado da requisição
				.expectBody()
				.jsonPath("$").isArray() // espera que retorne um json

				//como estou usando outro bd (h2), esperasse que só tenha uma tarefa no bd
				//só que como o teste de update esta sendo executado primeiro, tera duas tarefas
				.jsonPath("$.length()").isEqualTo(2)

				//expectativa dos dados recebidos
				.jsonPath("$[0].name").isEqualTo(todo.getName())
				.jsonPath("$[0].description").isEqualTo(todo.getDescription())
				.jsonPath("$[0].realization").isEqualTo(todo.getRealization())
				.jsonPath("$[0].priority").isEqualTo(todo.getPriority());
	}

	@Test
	void TestCreateTodoFail() {

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new Todo("", "", false, 0)
				)
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	void TesteUpdateSuccess(){

		var todo = new Todo("todo1", "desc todo1", false, 7);

		//Criando uma tarefa
		List<Todo> tarefaCriada = webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Todo.class)
				.returnResult()
				.getResponseBody();



		// verificando se a tarefa é nula ou esta vazia
		if (tarefaCriada == null || tarefaCriada.isEmpty()){
			throw new AssertionError("A requisição POST não retornou nenhuma tarefa.");
		}

		long idTarefaCriada = tarefaCriada.get(0).getId();

		var tarefaAtualizada = new Todo("tarefa2", "desc todo2", true, 1);


		tarefaAtualizada.setId(idTarefaCriada);

		webTestClient
				.put()
				.uri("/todos")
				.bodyValue(tarefaAtualizada)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray() // espera que retorne um json
				//como estou usando outro bd (h2), esperasse que só tenha uma tarefa no bd
				.jsonPath("$.length()").isEqualTo(1)
				//expectativa dos dados recebidos
				.jsonPath("$[0].id").isEqualTo(tarefaAtualizada.getId())
				.jsonPath("$[0].name").isEqualTo(tarefaAtualizada.getName())
				.jsonPath("$[0].description").isEqualTo(tarefaAtualizada.getDescription())
				.jsonPath("$[0].realization").isEqualTo(tarefaAtualizada.getRealization())
				.jsonPath("$[0].priority").isEqualTo(tarefaAtualizada.getPriority());
	}
}
