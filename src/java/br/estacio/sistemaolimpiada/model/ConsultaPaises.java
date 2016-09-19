/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.PaisDAO;
import br.estacio.sistemaolimpiada.entity.Pais;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class ConsultaPaises implements RegraDeNegocio {

    @Override
    public String executarRegraDeNegocio(HttpServletRequest request, HttpServletResponse response) {
        PaisDAO paisDAO = new PaisDAO();
        
        List<Pais> paises = paisDAO.selectAll();
        
        request.setAttribute("paises", paises);
        
        String paginaRetorno = "/lista_paises.jsp";
        return paginaRetorno;
    }
    
}
