/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 * @param <T>
 */
public interface DAO<T> {
    
    public void update(T tipo);
    
    public void insert(T tipo) throws SQLIntegrityConstraintViolationException;
    
    public void delete(long codigo);
    
    public List<T> selectAll();
    
    public T selectById(long codigo);
}
