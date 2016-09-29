/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.PaisDAO;
import br.estacio.sistemaolimpiada.entity.Pais;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class CadastroPais implements RegraDeNegocio {

    @Override
    public String executarRegraDeNegocio(HttpServletRequest request, HttpServletResponse response) {
        PaisDAO paisDAO = new PaisDAO();
        String nomePais = (String) request.getParameter("nomePais");
        
        Pais pais = new Pais();
        pais.setNome(nomePais);
        
        paisDAO.insert(pais);
        
        String caminho = "lista_paises.jsp";
        
        request.setAttribute("caminho", caminho);
        
        String paginaRetorno = "cadastro_sucesso.jsp";
        
        return paginaRetorno;
    }
    
}
