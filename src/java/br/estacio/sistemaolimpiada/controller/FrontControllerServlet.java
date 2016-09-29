/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.controller;

import br.estacio.sistemaolimpiada.model.RegraDeNegocio;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
@WebServlet(name = "FrontControllerServlet", urlPatterns = {"/sistema"})
public class FrontControllerServlet extends HttpServlet {

    private static final String ENCODING = "UTF-8";
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
        
        RegraDeNegocio regraDeNegocio = instanciarRegraDeNegocio(request);
        
        String caminhoPagina = regraDeNegocio.executarRegraDeNegocio(request, response);
        
        request.getRequestDispatcher(caminhoPagina).forward(request, response);

    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("index.jsp");
    }

    private RegraDeNegocio instanciarRegraDeNegocio(HttpServletRequest request) {
        StringBuilder regraDeNegocioBuilder = new StringBuilder();
        
        String caminhoBase = "br.estacio.sistemaolimpiada.model.";      
        
        String regraDeNegocio = request.getParameter("regraDeNegocio");
    
        if (regraDeNegocio == null) 
            throw new IllegalArgumentException("Não é possível executar essa operação.");
        
        regraDeNegocioBuilder.append(caminhoBase);
        regraDeNegocioBuilder.append(regraDeNegocio);
        
        RegraDeNegocio regraDeNegocioServlet = null;
        
        try {
            
            Class<?> classe = Class.forName(regraDeNegocioBuilder.toString());
            
            regraDeNegocioServlet = (RegraDeNegocio) classe.newInstance();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FrontControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return regraDeNegocioServlet;
    }
    
}
