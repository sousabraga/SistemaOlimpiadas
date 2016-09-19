<%-- 
    Document   : cadastro_de_paises
    Created on : Sep 18, 2016, 6:45:46 PM
    Author     : matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <title>Cadastro de Países</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" flush="true"/>
        
        <section class="conteudo">
            <div class="container">
                <div class="page-header">
                    <h1>Cadastro de Países</h1>
                </div>    
                
                <form action="sistema" id="formulario" method="POST">
                    <input name="regraDeNegocio" type="hidden" value="CadastroPais"/>
                    
                    <div class="form-group">
                        <label for="pais">Nome do País:</label>
                        <input name="nomePais" id="pais" type="text" class="form-control"/> 
                    </div>
                </form>
                <button type="submit" form="formulario" class="btn btn-primary">
                    <span class="glyphicon glyphicon-plus-sign"></span>
                    Cadastrar País
                </button>
            </div>
        </section>
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
