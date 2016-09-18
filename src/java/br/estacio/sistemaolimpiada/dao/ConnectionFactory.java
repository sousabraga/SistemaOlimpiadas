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
 * @author matheus
 */
public final class ConnectionFactory {
    
    private static final String SERVIDOR = "jdbc:derby://localhost:1527/olimpiadas";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    
    private static Connection connection;
    
    private ConnectionFactory() {}
    
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return connection;
    }
    
}
