/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class PaisEsporteDAO implements DAO {

    private static final String TABLE = "paises_esportes";
    private static final String COL_CODIGO_PAIS = "codigo_pais";
    private static final String COL_CODIGO_ESPORTE = "codigo_esporte";
    private static final String COL_MEDALHA  = "medalha";
    
    public void insert(long codigoPais, long codigoEsporte, int codigoMedalha) {
        String sql = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)", 
                TABLE, COL_CODIGO_PAIS, COL_CODIGO_ESPORTE, COL_MEDALHA);
        
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
            ) {
            
            ps.setLong(1, codigoPais);
            ps.setLong(2, codigoEsporte);
            ps.setInt(3, codigoMedalha);
            
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void update(Object tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Object tipo) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object selectById(long codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
