<%-- 
    Document   : index
    Created on : Sep 17, 2016, 3:56:55 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
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
                <div class="media">
                    <div class="media-left">
                        <img id="logo" class="media-object" src="resources/imagens/logo_olimpiadas.png" alt="Logo">
                    </div>
                    <div class="media-body">
                        <h1 class="media-heading">Sistema Olimpíadas</h1>
                    </div>
                </div>

                <div class="page-header">
                    <h1>Ranking Geral</h1>
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th><h3>País<h3></th>
                            <th><img src="resources/imagens/medalhas/medalha_ouro.png" title="Ouro" alt="Ouro"/></th>
                            <th><img src="resources/imagens/medalhas/medalha_prata.png" title="Prata" alt="Prata"/></th>
                            <th><img src="resources/imagens/medalhas/medalha_bronze.png" title="Bronze" alt="Bronze"/></th>
                            <th><img src="resources/imagens/medalhas/medalhas.png" title="Total" alt="Total"/></th>
                        </tr>    
                    </thead>
                    <tbody>
                        <tr>
                            <td>teste</td>
                            <td>teste</td>
                            <td>teste</td>
                            <td>teste</td>
                            <td>teste</td>
                        </tr>
                        <tr>
                            <td>teste</td>
                            <td>teste</td>
                            <td>teste</td>
                            <td>teste</td>
                            <td>teste</td>
                        </tr>
                        <tr>
                            <td>teste</td>
                            <td>teste</td>
                            <td>teste</td>
                            <td>teste</td>
                            <td>teste</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </section> 
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
