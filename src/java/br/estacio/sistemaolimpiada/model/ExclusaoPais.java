/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.PaisDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class ExclusaoPais implements RegraDeNegocio {

    @Override
    public String executarRegraDeNegocio(HttpServletRequest request, HttpServletResponse response) {
        PaisDAO paisDAO = new PaisDAO();
        
        long codigoPais = Long.parseLong(request.getParameter("codigoPais"));
        paisDAO.delete(codigoPais);
        
        String caminho = "lista_paises.jsp";
        request.setAttribute("caminho", caminho);
        
        String paginaRetorno = "pagina_sucesso.jsp";
        
        return paginaRetorno;
    }
    
    
}
