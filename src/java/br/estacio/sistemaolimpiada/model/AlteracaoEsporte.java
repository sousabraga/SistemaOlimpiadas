/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.EsporteDAO;
import br.estacio.sistemaolimpiada.entity.Esporte;
import java.util.Map;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class AlteracaoEsporte implements RegraDeNegocio{
    
    public static final String CODIGO_ESPORTE_KEY = "codigoEsporte";
    public static final String NOME_ESPORTE_KEY = "nomeEsporte";

    @Override
    public void executarRegraDeNegocio(Map<String, String[]> parametrosRequisicao, Map<String, Object[]> parametrosResposta) {
        long codigoEsporte = Long.parseLong(parametrosRequisicao.get(CODIGO_ESPORTE_KEY)[0]);
        String nomeEsporte = parametrosRequisicao.get(NOME_ESPORTE_KEY)[0];
        
        EsporteDAO dao = new EsporteDAO();
        
        Esporte esporte = new Esporte(codigoEsporte, nomeEsporte);
        
        dao.update(esporte);
    }
    
    
    
}
