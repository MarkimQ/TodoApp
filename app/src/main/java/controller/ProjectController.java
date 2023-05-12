/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import utill.ConnectionFactory;

/**
 *
 * @author TI
 */
public class ProjectController {
    
    public void save(Project project){
        
        String sql = "INSERT INTO projetos (nome, descricao, data_criacao, data_att) VALUES(?,?,?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getNome());
            statement.setString(2, project.getDescricao());
            statement.setDate(3, new Date (project.getData_criacao().getTime()));
            statement.setDate(4, new Date (project.getData_att().getTime()));
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("erro ao salvar o Project" + ex.getMessage(), ex);   
        }finally {
            ConnectionFactory.CloseConecction(connection, statement);
        }
        
    }
    
    public void update(Project project){
        // SQL PARA ALTERAR A TABELA TAREFAS , O VALOR ? SERA ALTERADO NO STATEMENT
         String sql = "UPDATE projetos SET nome = ?, descricao = ?, data_criacao = ?, data_att = ? WHERE id = ?";
         
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getNome());
            statement.setString(2, project.getDescricao());
            statement.setDate(3, new Date (project.getData_criacao().getTime()));
            statement.setDate(4, new Date (project.getData_att().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("erro ao alterar o Projeto"
                   + ex.getMessage(), ex);   
        }finally {
            ConnectionFactory.CloseConecction(connection, statement);
        }
        
    }
    
    public void removeById(int id) {
        String sql = "DELETE FROM projetos WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        }catch (Exception ex) {
            throw new RuntimeException("erro ao remover o Projeto"
                   + ex.getMessage(), ex);   
        } finally {
            ConnectionFactory.CloseConecction(connection, statement);
        }
    }
    
    public List<Project> getAll(){
        String sql = "SELECT * FROM projetos";
                
        List<Project> projects = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;         
        ResultSet resultSet = null;
        
        //Lista de tarefas devolvida quando a chamada do metodo acontecer   
         try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
             while (resultSet.next()) {  
                 
                 Project project = new Project();
                 
                 project.setId(resultSet.getInt("id"));
                 project.setNome(resultSet.getString("nome"));
                 project.setDescricao(resultSet.getString("descricao"));
                 project.setData_criacao(resultSet.getDate("data_criacao"));
                 project.setData_att(resultSet.getDate("data_att"));
                 
                 projects.add(project);
             }      
        }catch (Exception ex) {
            throw new RuntimeException("erro ao Listar os Projetos"
                   + ex.getMessage(), ex);   
        } finally {
            ConnectionFactory.CloseConecction(connection, statement, resultSet);
        }                
        return projects
                ; //retorna lista de tarefas criadas acima
    }

    
}
