/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public final class ConnectionFactory {
    
    private static final String SERVIDOR = "jdbc:mysql://localhost:3306/olimpiadas";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";
    
    private static Connection connection;
    
    private ConnectionFactory() {}
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        
        return connection;
    }
    
}
