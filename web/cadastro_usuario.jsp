<%-- 
    Document   : cadastro_usuario
    Created on : Dec 4, 2016, 6:32:13 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bibliotecas CSS -->
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        
        <!-- Bibliotecas JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <script type="text/javascript" src="resources/script.js"></script>
        
        <title>Login</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" flush="true"/>
        
        <section class="conteudo">
            
            <div class="container">
                <div class="page-header">
                    <h1>Cadastro de Usuário</h1>
                </div>

                <% 
                    String msgErro = (String) request.getSession().getAttribute("msgErro");
                    
                    if (msgErro != null) {
                        request.getSession().removeAttribute("msgErro");
                %>
                        <div class="alert alert-danger fade in" role="alert">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <span class="glyphicon glyphicon-alert"></span>
                            <%= msgErro %>
                        </div>
                <% } %>

                <div class="mensagens">
                    <span class="label label-danger" id="mensagemErro"></span>
                    <span class="label label-success" id="mensagemSucesso"></span>
                </div>
                <br/>
                
                <form action="#" method="POST" onsubmit="return validaFormCadastroUsuario();">
                    <div class="form-group">
                        <label class="control-label" for="email">E-mail:</label>
                        <input name="email" id="email" type="email" class="form-control" onfocus="limpaMensagens();"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="login">Login:</label>
                        <input name="login" id="login" type="text" class="form-control" onfocus="limpaMensagens();"/>
                    </div>
                    <div class="form-group">
                      <label class="control-label" for="senha">Senha:</label>
                      <input name="senha" id="senha" type="password" class="form-control" onfocus="limpaMensagens();"/>
                    </div>
                    <div class="form-group">
                      <label class="control-label" for="confirmacaoSenha">Confirmação da Senha:</label>
                      <input name="confirmacaoSenha" id="confirmacaoSenha" type="password" class="form-control" onfocus="limpaMensagens();"/>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-log-in"></span>
                        &nbsp Cadastrar
                    </button>
                </form>

            </div>
                
        </section>
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
