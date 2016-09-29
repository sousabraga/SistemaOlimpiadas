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
public class CadastroEsporte implements RegraDeNegocio {

    public static final String NOME_ESPORTE_KEY = "nomeEsporte";
    
    @Override
    public void executarRegraDeNegocio(Map<String, String[]> parametrosRequisicao, Map<String, String[]> parametrosResposta) {
        String nome = parametrosRequisicao.get(NOME_ESPORTE_KEY)[0];
        
        Esporte esporte = new Esporte();
        esporte.setNome(nome);
        
        EsporteDAO dao = new EsporteDAO();
        dao.insert(esporte);
    }
    
}
