<%-- 
    Document   : index
    Created on : Sep 17, 2016, 3:56:55 PM
    Author     : matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <title>Sistema Olimpíadas</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" flush="true"/>
        
        <section class="conteudo">
            <div class="container">
                <img src="resources/imagens/logo_olimpiadas.png" alt="Logo">
                <h1>Sistema das Olimpíadas</h1>
            </div>    
        </section>    
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
