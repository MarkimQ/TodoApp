/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TI
 */
public class ConnectionFactory {
    
      //Driver usado para conectar no banco
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //define a URL de acesso ao banco de dados
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";    
    //usuario padrão de acesso ao banco
    public static final String USER = "root";
    // senha para acesso ao banco
    public static final String PASS = "";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Erro na conexão com o Banco de Dados", ex);
        }
    }
    
    public static void CloseConecction(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }

        } catch (Exception ex){
            throw new RuntimeException("Erro ao fechar conexão com o Banco de Dados", ex);
            }
    }
    
    public static void CloseConecction(Connection connection, PreparedStatement statement){
        try {
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
        } catch (Exception ex){
            throw new RuntimeException("Erro ao fechar conexão com o Banco de Dados", ex);
            }
    }
    
    public static void CloseConecction(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
            
        } catch (Exception ex){
            throw new RuntimeException("Erro ao fechar conexão com o Banco de Dados", ex);
            }
        }
    
        
}
