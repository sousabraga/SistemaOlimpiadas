<%-- 
    Document   : form_cadastro_esporte
    Created on : Sep 20, 2016, 7:26:36 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <title>Cadastro de Esportes</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" flush="true"/>
        
        <section class="conteudo">
            <div class="container">
                <div class="page-header">
                    <h1>Cadastro de Esportes</h1>
                </div>    
                
                <form action="sistema" id="formulario" method="POST">
                    <input name="regraDeNegocio" type="hidden" value="CadastroEsporte"/>
                    
                    <div class="form-group">
                        <label for="esporte">Nome do Esporte:</label>
                        <input name="nomeEsporte" id="esporte" type="text" class="form-control"/> 
                    </div>
                </form>
                <button type="submit" form="formulario" class="btn btn-primary">
                    <span class="glyphicon glyphicon-plus-sign"></span>
                    Cadastrar Esporte
                </button>
            </div>
        </section>
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>

