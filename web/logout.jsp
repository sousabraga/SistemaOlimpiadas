<%-- 
    Document   : logout
    Created on : Nov 30, 2016, 8:17:33 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        
        <title>Logout</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" flush="true"/>
        
        <section class="conteudo">
            
            <div class="container">
            
                <div class="jumbotron">
                    <h1>Logout efetuado com sucesso!</h1>
                    <p>Volte sempre! ;)</p>
                </div>
            
            </div>
                
        </section>
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
