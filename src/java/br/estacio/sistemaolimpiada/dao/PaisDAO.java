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
 * @author matheus
 */
public class PaisDAO implements DAO<Pais> {
    
    @Override
    public void update(Pais pais) {
        String sql = "UPDATE paises SET nome = ? WHERE codigo = ?";
        
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
        String sql = "INSERT INTO paises (nome) VALUES (?)";
        
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
        
        String sql = "DELETE FROM paises WHERE codigo = ?";
        
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
        List<Pais> listaPaises = new ArrayList<>();
        String sql = "SELECT * FROM paises";      
       
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
        String sql = "SELECT * FROM paises WHERE codigo = " + codigo;
        
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
    
    public int getTotalMedalhas(Pais pais) {
        String sql = "SELECT COUNT(*) AS count FROM paises_esportes WHERE fk_codigo_pais = " + pais.getCodigo();
        
        int total = 0;
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            ) {
            
           if (rs.next()) {
               total = rs.getInt("count");
           }
           
           return total;
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
        String sql = "SELECT COUNT(*) AS count FROM paises_esportes WHERE fk_codigo_pais = " + pais.getCodigo() + " AND medalha = " + medalha;
        
        int total = 0;
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            ) {
            
           if (rs.next()) {
               total= rs.getInt("count");
           }
           
           return total;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
