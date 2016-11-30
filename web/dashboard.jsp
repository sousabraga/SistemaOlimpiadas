<%-- 
    Document   : dashboard
    Created on : 28/09/2016, 18:16:44
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
        <title>Dashboard</title>
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
                <br/>
                <% 
                    String msgSucesso = (String) request.getSession().getAttribute("msgSucesso");
                    
                    if (msgSucesso != null) { 
                        request.getSession().removeAttribute("msgSucesso");
                %>    
                        <div class="alert alert-success fade in" role="alert">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <span class="glyphicon glyphicon-ok-sign"></span>
                            <%= msgSucesso %>
                        </div> 
                        
                <% } %>
                
                <div class="page-header">
                    <h1>Dashboard</h1>
                </div>  
                
                <div class="panel panel-default" id="painel">
                    <div class="panel-body"><h4>País</h4></div>
                    <div class="panel-footer">
                        <a href="form_cadastro_pais.jsp">
                            <button type="button" form="formulario" class="btn btn-primary">
                                <span class="glyphicon glyphicon-plus-sign"></span>
                                Cadastrar País
                            </button>
                        </a>
                        &nbsp;
                        <a href="lista_paises.jsp">
                            <button type="submit" form="formulario" class="btn btn-primary">
                                <span class="glyphicon glyphicon-th-list"></span>
                                Listar Paises
                            </button>
                        </a>
                    </div>
                </div>
                <br/>
                <div class="panel panel-default" id="painel">
                    <div class="panel-body"><h4>Esporte</h4></div>
                    <div class="panel-footer">
                        <a href="form_cadastro_esporte.jsp">
                            <button type="submit" form="formulario" class="btn btn-primary">
                                <span class="glyphicon glyphicon-plus-sign"></span>
                                Cadastrar Esporte
                            </button>
                        </a>
                        &nbsp;
                        <a href="lista_esportes.jsp">
                            <button type="submit" form="formulario" class="btn btn-primary">
                                <span class="glyphicon glyphicon-th-list"></span>
                                Listar Esportes
                            </button>
                        </a>
                    </div>
                </div>
                <br/>
                <div class="panel panel-default" id="painel">
                    <div class="panel-body"><h4>Medalhista</h4></div>
                    <div class="panel-footer">
                        <a href="form_cadastro_medalhista.jsp">
                            <button type="submit" form="formulario" class="btn btn-primary">
                                <span class="glyphicon glyphicon-plus-sign"></span>
                                Cadastrar Medalhista
                            </button>
                        <a>
                        &nbsp;
                        <a href="ranking.jsp">
                            <button type="submit" form="formulario" class="btn btn-primary">
                                <span class="glyphicon glyphicon-th-list"></span>
                                Listar Medalhistas
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </section>
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
