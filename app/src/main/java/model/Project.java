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
public class Project {
    private int id;
    private String nome;
    private String descricao;
    private Date data_criacao;
    private Date data_att;

    public Project(int id, String nome, String descricao, Date data_criacao, Date data_att) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data_criacao = data_criacao;
        this.data_att = data_att;
    }
    
    public Project(){
         this.data_criacao = new Date();
          this.data_att = new Date();
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return this.nome;
    }
    
    
}
