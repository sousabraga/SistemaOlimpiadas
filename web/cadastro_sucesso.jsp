<%-- 
    Document   : pagina_sucesso
    Created on : Sep 20, 2016, 4:03:40 PM
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
        String mensagemSucesso = "Cadastro efetuado com sucesso.";
      
        request.getSession().setAttribute("msgSucesso", mensagemSucesso);
      }
      
      response.sendRedirect(caminho);
    %>
    
</html>
