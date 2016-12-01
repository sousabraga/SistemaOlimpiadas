<%-- 
    Document   : alteracao_sucesso
    Created on : Nov 30, 2016, 9:33:53 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
      String caminho = (String) request.getAttribute("caminho");
      
      String mensagemErro[] = (String[]) request.getAttribute("msgErro");
      
      if (mensagemErro != null) {
         request.getSession().setAttribute("msgErro", mensagemErro[0]); 
      } else {
        String mensagemSucesso = "Alteração efetuada com sucesso.";
      
        request.getSession().setAttribute("msgSucesso", mensagemSucesso);
      }
      
      response.sendRedirect(caminho);
    %>
</html>
