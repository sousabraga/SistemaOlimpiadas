/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author matheus
 */
public interface RegraDeNegocio {
    
    public String executarRegraDeNegocio(HttpServletRequest request, HttpServletResponse response);
    
}
