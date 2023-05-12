/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author TI
 */
public class Task {
     private int id;
    private int id_projeto;
    private String nome;
    private String descricao;
    private String Observacao;
    private Date prazo;
    private Date data_criacao;
    private Date data_att;
    private Boolean completada;

    public Task(int id, int id_projeto, String nome, String descricao, String Observacao, Date prazo, Date data_criacao, Date data_att, Boolean completada) {
        this.id = id;
        this.id_projeto = id_projeto;
        this.nome = nome;
        this.descricao = descricao;
        this.Observacao = Observacao;
        this.prazo = prazo;
        this.data_criacao = data_criacao;
        this.data_att = data_att;
        this.completada = completada;
    }
    
     public Task(){
         this.data_criacao = new Date();
         this.data_att = new Date();
         this.prazo = new Date();
         this.completada = false;
     }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Date getData_att() {
        return data_att;
    }

    public void setData_att(Date data_att) {
        this.data_att = data_att;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "id=" + id + ", id_projeto=" + id_projeto + ", nome=" + nome + ", descricao=" + descricao + ", Observacao=" + Observacao + ", prazo=" + prazo + ", data_criacao=" + data_criacao + ", data_att=" + data_att + ", completada=" + completada + '}';
    }

    public boolean completada() {
        return completada;
    }
    
    
    
}
