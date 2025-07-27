package br.com.filipelisboa.desafio_todolist.entity;


import jakarta.persistence.*;


//No contexto de bancos de dados e mapeamento objeto-relacional (ORM),
// uma entidade é uma classe Java que representa uma tabela em um banco de dados.
// Cada instância dessa classe corresponde a uma linha (registro) na tabela.

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id gerado altomaticamente no bd
    private  long id;

    // campos da tabela
    private  String name;
    private  String description;
    private  boolean realization;
    private  int priority;


    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRealization() {
        return realization;
    }

    public void setRealization(boolean realization) {
        this.realization = realization;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
