package br.com.filipelisboa.desafio_todolist.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id gerado altomaticamente no bd
    private  long id;
    private  String name;
    private  String description;
    private  boolean realization;
    private  int prioridade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getName() {
        return name;
    }
}
