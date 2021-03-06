<%-- 
    Document   : form_cadastro_pais
    Created on : Sep 18, 2016, 6:45:46 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <script type="text/javascript" src="resources/script.js"></script>
        <title>Cadastro de Países</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" flush="true"/>
        
        <section class="conteudo">
            <div class="container">
                <div class="page-header">
                    <h1>Cadastro de Países</h1>
                </div>    
                
                <span class="label label-danger" id="mensagemErro"></span>
                <br/><br/>
                
                <form action="sistema" method="POST" onsubmit="return validaValorInput();">
                    <input name="regraDeNegocio" type="hidden" value="CadastroPais"/>
                    
                    <div class="form-group">
                        <label class="control-label" for="valorInput">Nome do País:</label>
                        <input name="nomePais" id="valorInput" type="text" class="form-control" autofocus required onfocus="limpaMensagemErro();"/> 
                    </div>
                    
                    <button type="submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-plus-sign"></span>
                        Cadastrar País
                    </button>
                </form>
            </div>
        </section>
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
