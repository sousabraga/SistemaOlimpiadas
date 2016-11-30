/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.PaisEsporteDAO;
import java.util.Map;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno 
 */
public class CadastroMedalhista implements RegraDeNegocio {

    public static final String CODIGO_PAIS_KEY = "codigoPais"; 
    public static final String CODIGO_ESPORTE_KEY = "codigoEsporte";
    public static final String CODIGO_MEDALHA_KEY = "codigoMedalha";
         
    @Override
    public void executarRegraDeNegocio(Map<String, String[]> parametrosRequisicao, Map<String, Object[]> parametrosResposta) {
        long codigoPais = Long.valueOf(parametrosRequisicao.get(CODIGO_PAIS_KEY)[0]);
        long codigoEsporte = Long.valueOf(parametrosRequisicao.get(CODIGO_ESPORTE_KEY)[0]);
        int codigoMedalha = Integer.valueOf(parametrosRequisicao.get(CODIGO_MEDALHA_KEY)[0]);
        
        PaisEsporteDAO dao = new PaisEsporteDAO();
        dao.insert(codigoPais, codigoEsporte, codigoMedalha);
    }
    
}
