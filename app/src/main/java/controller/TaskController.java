/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import utill.ConnectionFactory;

/**
 *
 * @author TI
 */
public class TaskController {
    
     public void save(Task task){
        
        String sql = "INSERT INTO tarefas (id_projeto, nome,"
                + " descricao, completada,"
                + " observacao, prazo, data_criacao,"
                + " data_att) VALUES(?,?,?,?,?,?,?,?)";
    
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt    (1, task.getId_projeto());
            statement.setString (2, task.getNome());
            statement.setString (3, task.getDescricao());
            statement.setBoolean(4, task.getCompletada());
            statement.setString (5, task.getObservacao());
            statement.setDate   (6, new Date (task.getPrazo().getTime()));
            statement.setDate   (7, new Date (task.getData_criacao().getTime()));
            statement.setDate   (8, new Date (task.getData_att().getTime()));
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao salvar a Tarefa", ex);   
        }finally {
            ConnectionFactory.CloseConecction(connection, statement);
        }
        
    }
    
    public void update(Task task){
        // SQL PARA ALTERAR A TABELA TAREFAS , O VALOR ? SERA ALTERADO NO STATEMENT
         String sql = "UPDATE tarefas SET id_projeto=?, nome=?, descricao=?, observacao=?, completada=?,prazo=?,data_criacao=?,data_att=? WHERE id = ?";
    
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getId_projeto());
            statement.setString(2, task.getNome());
            statement.setString(3, task.getDescricao());
            statement.setString(4, task.getObservacao());
            statement.setBoolean(5, task.completada());
            statement.setDate(6, new Date (task.getPrazo().getTime()));
            statement.setDate(7, new Date (task.getData_criacao().getTime()));
            statement.setDate(8, new Date (task.getData_att().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao alterar a Tarefa"+ ex.getMessage(), ex);   
        }finally {
            ConnectionFactory.CloseConecction(connection, statement);
        }
        
    }
    
    public void removeById(int taskid) {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskid);
            statement.execute();
        }catch (SQLException ex) {
            throw new RuntimeException("erro ao remover a Tarefa", ex);   
        } finally {
            ConnectionFactory.CloseConecction(connection, statement);
        }
    }
    
    public List<Task> getAll(int id_projeto){
        String sql = "SELECT * FROM tarefas WHERE id_projeto = ?";
                
        Connection connection = null;
        PreparedStatement statement = null;         
        ResultSet resultSet = null;
        
        //Lista de tasks devolvida quando a chamada do metodo acontecer
        List<Task> tasks = new ArrayList<>();
        
               
         try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id_projeto);
            resultSet = statement.executeQuery();
            
             while (resultSet.next()) {  
                 
                 Task task = new Task();
                 task.setId(resultSet.getInt("id"));
                 task.setId_projeto(resultSet.getInt("id_projeto"));
                 task.setNome(resultSet.getString("nome"));
                 task.setDescricao(resultSet.getString("descricao"));
                 task.setObservacao(resultSet.getString("observacao"));
                 task.setCompletada(resultSet.getBoolean("completada"));
                 task.setPrazo(resultSet.getDate("prazo"));
                 task.setData_criacao(resultSet.getDate("data_criacao"));
                 task.setData_att(resultSet.getDate("data_att"));
                 
                 tasks.add(task);
             }      
        }catch (SQLException ex) {
            throw new RuntimeException("erro ao Listar as Tarefas" + ex.getMessage(), ex);   
        } finally {
            ConnectionFactory.CloseConecction(connection, statement, resultSet);
        }                
        return tasks; //retorna lista de tasks criadas acima
    }
    
}
