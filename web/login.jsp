<%-- 
    Document   : ranking
    Created on : Sep 17, 2016, 7:08:52 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" flush="true"/>
        
        <section class="conteudo">
            
            <div class="container">
                <div class="page-header">
                    <h1>Login Administrador</h1>
                </div>

                <form action="sistema" id="formulario" method="POST">
                    <div class="form-group">
                        <label for="usuario">Usuário:</label>
                        <input name="usuario" id="usuario" type="text" class="form-control" autofocus="true"/>
                    </div>
                    <div class="form-group">
                      <label for="senha">Senha:</label>
                      <input name="senha" id="senha" type="password" class="form-control"/>
                    </div>
                </form>

                <button type="submit" form="formulario" class="btn btn-primary">
                    <span class="glyphicon glyphicon-log-in"></span>
                    &nbsp Logar
                </button>
            </div>
            
        </section>
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
