/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.dao;

import br.estacio.sistemaolimpiada.entity.Esporte;
import br.estacio.sistemaolimpiada.entity.Medalha;
import br.estacio.sistemaolimpiada.entity.Pais;
import br.estacio.sistemaolimpiada.util.EsporteComMedalhas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void insert(Pais pais) throws SQLIntegrityConstraintViolationException {
        String sql = String.format("INSERT INTO %s (%s) VALUES (?)", TABLE, COL_NOME);
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);            
            ) {
            
            ps.setString(1, pais.getNome());                
            ps.execute();               
            
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException)
                throw new SQLIntegrityConstraintViolationException();
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
    
    public List<EsporteComMedalhas> getTotalMedalhasPorEsporte(long codigoPais) {
        String sqlEsportes = "SELECT * FROM esportes WHERE codigo IN (SELECT codigo_esporte FROM paises_esportes WHERE codigo_pais = ?)";

        String sqlMedalhasOuro = "SELECT COUNT(*) AS ouro FROM paises_esportes WHERE codigo_pais = ? AND codigo_esporte = ? AND medalha = 1";
        String sqlMedalhasPrata = "SELECT COUNT(*) AS prata FROM paises_esportes WHERE codigo_pais = ? AND codigo_esporte = ? AND medalha = 2";
        String sqlMedalhasBronze = "SELECT COUNT(*) AS bronze FROM paises_esportes WHERE codigo_pais = ? AND codigo_esporte = ? AND medalha = 3";
        
        List<Esporte> esportes = new ArrayList<>();
        
        List<EsporteComMedalhas> medalhasPorEsporte = new ArrayList<>();
        
        int totalOuro = 0;
        int totalPrata = 0;
        int totalBronze = 0;
        
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null; 
        
        try {
            connection = ConnectionFactory.getConnection();
            
            ps = connection.prepareStatement(sqlEsportes);
            ps.setLong(1, codigoPais);
            
            rs = ps.executeQuery();
        
            while (rs.next()) {
                Esporte esporte = new Esporte();
                esporte.setCodigo(rs.getLong("codigo"));
                esporte.setNome(rs.getString("nome"));
                
                esportes.add(esporte);
            }
            
            if (!esportes.isEmpty()) {
                for (Esporte esporte : esportes) {
                    ps = connection.prepareStatement(sqlMedalhasOuro);
                    ps.setLong(1, codigoPais);
                    ps.setLong(2, esporte.getCodigo());
                    
                    rs = ps.executeQuery();
                    
                    if (rs.next()) {
                        totalOuro = rs.getInt("ouro");
                    }
                    
                    rs.close();
                    ps.close();
                    
                    ps = connection.prepareStatement(sqlMedalhasPrata);
                    ps.setLong(1, codigoPais);
                    ps.setLong(2, esporte.getCodigo());
                    
                    rs = ps.executeQuery();
                    
                    if (rs.next()) {
                        totalPrata = rs.getInt("prata");
                    }
                    
                    rs.close();
                    ps.close();
                    
                    ps = connection.prepareStatement(sqlMedalhasBronze);
                    ps.setLong(1, codigoPais);
                    ps.setLong(2, esporte.getCodigo());
                    
                    rs = ps.executeQuery();
                    
                    if (rs.next()) {
                        totalBronze = rs.getInt("bronze");
                    }
                    
                    EsporteComMedalhas esporteComMedalhas = new EsporteComMedalhas();
                    esporteComMedalhas.setNome(esporte.getNome());
                    esporteComMedalhas.setMedalhasOuro(totalOuro);
                    esporteComMedalhas.setMedalhasPrata(totalPrata);
                    esporteComMedalhas.setMedalhasBronze(totalBronze);
                    
                    medalhasPorEsporte.add(esporteComMedalhas);
                }
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException | NullPointerException ex) {
                Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return medalhasPorEsporte;
    }
    
}
