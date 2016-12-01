/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.controller;

import br.estacio.sistemaolimpiada.model.RegraDeNegocio;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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

    public static final String CAMINHO_KEY = "caminho";
    public static final String REGRA_DE_NEGOCIO_KEY = "regraDeNegocio";
    private static final String ENCODING = "UTF-8";
    private static final Map<String, String[]> CAMINHO;
    
    static {
        CAMINHO = new HashMap<>();
        CAMINHO.put("CadastroEsporte", new String[] {"lista_esportes.jsp", "cadastro_sucesso.jsp"});
        CAMINHO.put("CadastroPais", new String[] {"lista_paises.jsp", "cadastro_sucesso.jsp"});
        CAMINHO.put("CadastroMedalhista", new String[] {"ranking.jsp", "cadastro_sucesso.jsp"});
        CAMINHO.put("ExclusaoEsporte", new String[] {"lista_esportes.jsp", "exclusao_sucesso.jsp"});
        CAMINHO.put("ExclusaoPais", new String[] {"lista_paises.jsp","exclusao_sucesso.jsp"});
        CAMINHO.put("Login", new String[] {"dashboard.jsp","login_sucesso.jsp"});
        CAMINHO.put("AlteracaoPais", new String[] {"lista_paises.jsp","alteracao_sucesso.jsp"});
        CAMINHO.put("AlteracaoEsporte", new String[] {"lista_esportes.jsp","alteracao_sucesso.jsp"});
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
        
        String parametroRegraDeNegocio = request.getParameter(REGRA_DE_NEGOCIO_KEY);
        
        RegraDeNegocio regraDeNegocio = instanciarRegraDeNegocio(parametroRegraDeNegocio);
        
        Map<String, Object[]> parametrosResposta = new HashMap<>();
       
        regraDeNegocio.executarRegraDeNegocio(request.getParameterMap(), parametrosResposta);
        
        if (!parametrosResposta.isEmpty()) {
            Set<String> chaves = parametrosResposta.keySet();
            for (String chave : chaves)
                request.setAttribute(chave, parametrosResposta.get(chave));
        }
        
        request.setAttribute(CAMINHO_KEY, CAMINHO.get(parametroRegraDeNegocio)[0]);
        
        RequestDispatcher rq = request.getRequestDispatcher(CAMINHO.get(parametroRegraDeNegocio)[1]);
        rq.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        response.sendRedirect("index.jsp");
    }

    private RegraDeNegocio instanciarRegraDeNegocio(String nomeDaClasse) {
        StringBuilder nomeTotalmenteQualificado = new StringBuilder("br.estacio.sistemaolimpiada.model.");      
        
        if (nomeDaClasse == null || nomeDaClasse.compareTo("") == 0) 
            throw new IllegalArgumentException("Não é possível executar esta operação.");
        
        nomeTotalmenteQualificado.append(nomeDaClasse);
        
        RegraDeNegocio regraDeNegocio = null;
        
        try {
            Class<?> classe = Class.forName(nomeTotalmenteQualificado.toString());
            
            regraDeNegocio = (RegraDeNegocio) classe.newInstance();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Logger.getLogger(FrontControllerServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return regraDeNegocio;
    }
    
}
