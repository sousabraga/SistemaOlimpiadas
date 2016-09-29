/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.dao;

import br.estacio.sistemaolimpiada.entity.Medalha;
import br.estacio.sistemaolimpiada.entity.Pais;
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
public class PaisDAO implements DAO<Pais> {
    
    private static final String TABLE = "paises";
    private static final String COL_CODIGO = "codigo";
    private static final String COL_NOME = "nome";
    
    @Override
    public void update(Pais pais) {
        String sql = String.format("UPDATE %s SET %s = ? WHERE %s = ?", TABLE, 
                COL_NOME, COL_CODIGO);
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
            ) {
            
            ps.setString(1, pais.getNome());
            ps.setLong(2, pais.getCodigo());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public void insert(Pais pais) {
        String sql = String.format("INSERT INTO %s (%s) VALUES (?)", TABLE, COL_NOME);
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);            
            ) {
            
            ps.setString(1, pais.getNome());                
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
    public List<Pais> selectAll() {
        String sql = String.format("SELECT * FROM %s", TABLE);   
        
        List<Pais> listaPaises = new ArrayList<>();
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();  
            ) {
            
            while (rs.next()) {
                Pais pais = new Pais();
                pais.setCodigo(rs.getLong("codigo"));
                pais.setNome(rs.getString("nome"));
                listaPaises.add(pais);
            }
            
            return listaPaises;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }

    @Override
    public Pais selectById(long codigo) {
        String sql = String.format("SELECT * FROM %s WHERE %s = %d", TABLE, COL_CODIGO, codigo);
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            ) {
            
            Pais pais = null;
            
            if (rs.next()) { 
                pais = new Pais();
                pais.setCodigo(rs.getLong("codigo"));
                pais.setNome(rs.getString("nome"));
            }
            
            return pais;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pais> selectAllComMedalhas() {
        String sql = String.format("SELECT * FROM %s", TABLE);   
        
        List<Pais> listaPaises = new ArrayList<>();
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();  
            ) {
            
            while (rs.next()) {
                Pais pais = new Pais();
                pais.setCodigo(rs.getLong("codigo"));
                pais.setNome(rs.getString("nome"));
                
                pais.setQtdMedalhasOuro(getTotalMedalhasOuro(pais));
                pais.setQtdMedalhasPrata(getTotalMedalhasPrata(pais));
                pais.setQtdMedalhasBronze(getTotalMedalhasBronze(pais));

                listaPaises.add(pais);
            }
            
            return listaPaises;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
    
    public int getTotalMedalhasOuro(Pais pais) {
        return getTotalMedalhasX(pais, Medalha.OURO);
    }
    
    public int getTotalMedalhasPrata(Pais pais) {
        return getTotalMedalhasX(pais, Medalha.PRATA);
    }
    
    public int getTotalMedalhasBronze(Pais pais) {
        return getTotalMedalhasX(pais, Medalha.BRONZE);
    }
    
    private int getTotalMedalhasX(Pais pais, Medalha medalha) {
        String sql = "SELECT COUNT(*) AS total FROM paises_esportes WHERE codigo_pais = " + pais.getCodigo() + " AND medalha = " + medalha.getCodigo();
        
        int total = 0;
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            ) {
            
           if (rs.next()) {
               total= rs.getInt("total");
           }
           
           return total;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
