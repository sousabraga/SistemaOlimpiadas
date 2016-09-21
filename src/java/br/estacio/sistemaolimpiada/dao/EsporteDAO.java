/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.dao;

import br.estacio.sistemaolimpiada.entity.Esporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class EsporteDAO implements DAO<Esporte> {

    private static final String TABLE = "esportes";
    private static final String COL_CODIGO = "codigo";
    private static final String COL_NOME = "nome";
    
    @Override
    public void update(Esporte esporte) {
        String sql = String.format("UPDATE %s SET %s = ? WHERE %s = ?", TABLE, 
                COL_NOME, COL_CODIGO);
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
            ) {
            
            ps.setString(1, esporte.getNome());
            ps.setLong(2, esporte.getCodigo());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public void insert(Esporte esporte) {
        String sql = String.format("INSERT INTO %s (%s) VALUES (?)", TABLE, COL_NOME);
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
            ) {
            
            ps.setString(1, esporte.getNome());
            
            ps.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long codigo) {
        String sql = String.format("DELETE FROM %s WHERE %s = ?", TABLE, COL_CODIGO);
        
        try (
             Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);                 
           ) {
            
            ps.setLong(1, codigo);
            
            ps.execute();
           
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        
    }

    @Override
    public List<Esporte> selectAll() {
        String sql = String.format("SELECT * FROM %s", TABLE);
        
        List<Esporte> esportes = new ArrayList<>();
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            ) {
            
            while (rs.next()) {
                Esporte esporte = new Esporte();
                esporte.setCodigo(rs.getLong(COL_CODIGO));
                esporte.setNome(rs.getString(COL_NOME));
                
                esportes.add(esporte);
            }
        
            return esportes;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public Esporte selectById(long codigo) {
        String sql = String.format("SELECT * FROM %s WHERE %s = %d", TABLE, COL_CODIGO, codigo);
        
        Esporte esporte = null;
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            ) {
            
            if (rs.next()) {
                esporte = new Esporte();
                esporte.setCodigo(rs.getLong(COL_CODIGO));
                esporte.setNome(rs.getString(COL_NOME));
            }
            
            return esporte;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
