/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.EsporteDAO;
import br.estacio.sistemaolimpiada.entity.Esporte;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class CadastroEsporte implements RegraDeNegocio {

    @Override
    public String executarRegraDeNegocio(HttpServletRequest request, HttpServletResponse response) {
        EsporteDAO esporteDAO = new EsporteDAO();
        
        Esporte esporte = new Esporte();
        esporte.setNome(request.getParameter("nomeEsporte"));
        
        esporteDAO.insert(esporte);
        
        String caminho = "lista_esportes.jsp";
        
        request.setAttribute("caminho", caminho);
        
        String caminhoRetorno = "cadastro_sucesso.jsp";      
        
        return caminhoRetorno;
    }
    
}
