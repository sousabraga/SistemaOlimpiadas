/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.dao;

import br.estacio.sistemaolimpiada.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class UsuarioDAO implements DAO<Usuario> {

    public Usuario selectByLogin(String login) {
        String sql = "SELECT * FROM usuarios WHERE login = ?";
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);  
            ) {
            
            ps.setString(1, login);
            
            Usuario usuario = null;
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setCodigo(rs.getLong("codigo"));
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                }
            }
            
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
    
    public Usuario selectByLoginAndSenha(String login, String senha) {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);  
            ) {
            
            ps.setString(1, login);
            ps.setString(2, senha);
            
            Usuario usuario = null;
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setCodigo(rs.getLong("codigo"));
                    usuario.setLogin(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                }
            }
            
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
    
    @Override
    public void update(Usuario tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Usuario tipo) throws SQLIntegrityConstraintViolationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario selectById(long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
