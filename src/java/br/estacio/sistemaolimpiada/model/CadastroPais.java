/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.PaisDAO;
import br.estacio.sistemaolimpiada.entity.Pais;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class CadastroPais implements RegraDeNegocio {

    public static final String NOME_PAIS_KEY = "nomePais";
    
    @Override
    public void executarRegraDeNegocio(Map<String, String[]> parametrosRequisicao, Map<String, Object[]> parametrosResposta) {
        String nomePais = (String) parametrosRequisicao.get(NOME_PAIS_KEY)[0];
        
        Pais pais = new Pais();
        pais.setNome(nomePais);
        
        PaisDAO dao = new PaisDAO();
        
        try {   
            dao.insert(pais);
        } catch (SQLIntegrityConstraintViolationException ex) {
            String msgErro[] = new String[1]; 
            msgErro[0] = "Não foi possível inserir. Motivo: país já está cadastrado.";
            
            parametrosResposta.put("msgErro", msgErro);
        }
    }
    
}
