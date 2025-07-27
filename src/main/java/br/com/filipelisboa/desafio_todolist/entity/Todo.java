package br.com.filipelisboa.desafio_todolist.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


//No contexto de bancos de dados e mapeamento objeto-relacional (ORM),
// uma entidade é uma classe Java que representa uma tabela em um banco de dados.
// Cada instância dessa classe corresponde a uma linha (registro) na tabela.

@Entity
@Table(name = "todos")
public class Todo {

    // campos da tabela

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id gerado altomaticamente no bd
    private  long id;

    @NotBlank
    private  String name;

    @NotBlank
    private  String description;

    private  boolean realization;
    private  int priority;

    public Todo(String name, String description, boolean realization, int priority) {
        this.name = name;
        this.description = description;
        this.realization = realization;
        this.priority = priority;
    }

// Getters e Setters

    // id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean getRealization() {
        return realization;
    }

    public void setRealization(boolean realization) {
        this.realization = realization;
    }

    // priority
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
