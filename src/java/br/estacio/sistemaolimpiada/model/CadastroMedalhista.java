/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.PaisEsporteDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno 
 */
public class CadastroMedalhista implements RegraDeNegocio {

    @Override
    public String executarRegraDeNegocio(HttpServletRequest request, HttpServletResponse response) {
        PaisEsporteDAO dao = new PaisEsporteDAO();
        
        long codigoPais = Long.valueOf(request.getParameter("codigoPais"));
        long codigoEsporte = Long.valueOf(request.getParameter("codigoEsporte"));
        int codigoMedalha = Integer.parseInt(request.getParameter("codigoMedalha"));
        
        dao.insert(codigoPais, codigoEsporte, codigoMedalha);
        
        String caminho = "ranking.jsp";
        
        request.setAttribute("caminho", caminho);
        
        String caminhoRetorno = "cadastro_sucesso.jsp";
        
        return caminhoRetorno;
    }
    
}
