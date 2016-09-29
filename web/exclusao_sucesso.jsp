<%-- 
    Document   : exclusao_sucesso
    Created on : Sep 28, 2016, 11:28:09 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <%
      String caminho = (String) request.getAttribute("caminho");
      
      String mensagemSucesso = "Exclusão efetuada com sucesso.";
      
      request.getSession().setAttribute("msgSucesso", mensagemSucesso);
      
      response.sendRedirect(caminho);
    %>
    
</html>
