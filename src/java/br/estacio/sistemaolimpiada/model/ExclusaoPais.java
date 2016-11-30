/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.PaisDAO;
import java.util.Map;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class ExclusaoPais implements RegraDeNegocio {

    public static final String CODIGO_PAIS_KEY = "codigoPais";
    
    @Override
    public void executarRegraDeNegocio(Map<String, String[]> parametrosRequisicao, Map<String, Object[]> parametrosResposta) {
        long codigoPais = Long.parseLong(parametrosRequisicao.get(CODIGO_PAIS_KEY)[0]);
        
        PaisDAO dao = new PaisDAO();
        dao.delete(codigoPais);
    }
    
}
