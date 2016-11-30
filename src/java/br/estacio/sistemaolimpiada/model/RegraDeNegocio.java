/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import java.util.Map;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public interface RegraDeNegocio {
    
    public void executarRegraDeNegocio(Map<String, String[]> parametrosRequisicao, Map<String, Object[]> parametrosResposta);
    
}
