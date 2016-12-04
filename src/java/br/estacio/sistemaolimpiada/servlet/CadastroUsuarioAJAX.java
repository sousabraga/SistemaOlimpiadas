/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
@WebServlet(name = "CadastroUsuarioAJAX", urlPatterns = {"/CadastroUsuarioAJAX"})
public class CadastroUsuarioAJAX extends HttpServlet {

    private static final String ENCODING = "UTF-8";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding(ENCODING);
        response.setCharacterEncoding(ENCODING);
                
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        JSONObject json = new JSONObject();

        try {
            json.put("respostaServidor", "Cadastro efetuado com sucesso. Aguarde um retorno para ativação.");
        } catch (JSONException ex) {
            Logger.getLogger(LoginAJAX.class.getName()).log(Level.SEVERE, null, ex);
        }

        PrintWriter out = response.getWriter();
        out.print(json.toString());
        out.close();
        
        
        request.getRequestDispatcher("cadastro_usuario.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
