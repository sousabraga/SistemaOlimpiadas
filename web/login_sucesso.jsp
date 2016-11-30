<%-- 
    Document   : login_sucesso
    Created on : Nov 28, 2016, 11:02:21 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page import="br.estacio.sistemaolimpiada.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
      String caminho = (String) request.getAttribute("caminho");
      
      String mensagemErro[] = (String[]) request.getAttribute("msgErro");
      
      if (mensagemErro != null) {
         request.getSession().setAttribute("msgErro", mensagemErro[0]);
         request.getRequestDispatcher("login.jsp").forward(request, response);
      } else {
        Object usuarioLogado[] = (Object[]) request.getAttribute("usuarioLogado");
        String mensagemSucesso = "Login efetuado com sucesso. Seja bem vindo.";
        
        request.getSession().setAttribute("usuarioLogado", usuarioLogado[0]);
        request.getSession().setAttribute("msgSucesso", mensagemSucesso);
      }
      
      response.sendRedirect(caminho);
    %>
    
</html>
