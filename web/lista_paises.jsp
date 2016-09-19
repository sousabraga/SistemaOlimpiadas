<%-- 
    Document   : index
    Created on : Sep 17, 2016, 3:56:55 PM
    Author     : matheus
--%>

<%@page import="java.util.List"%>
<%@page import="br.estacio.sistemaolimpiada.entity.Pais"%>
<%@page import="br.estacio.sistemaolimpiada.entity.Pais"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <title>Lista de Países</title>
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
                
                <% 
                    List<Pais> paises = (List) request.getAttribute("paises"); 
                    
                    if (paises == null || paises.isEmpty()) {
                %> 
                
                </br>
                
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-alert"/></span>
                    Nenhum país foi encontrado.
                </div>
                
                <%        
                    } else {
                %>
                
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th><h3>Países Cadastrados<h3></th>
                            <th><h3>Ações<h3></th>
                        </tr>    
                    </thead>
                    <tbody>
                        <% for (Pais pais : paises) { %>
                            
                            <tr>
                                <td><%= pais.getNome() %></td>
                                <td>
                                    <button type="submit" form="formulario" class="btn btn-warning">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                    <button type="submit" form="formulario" class="btn btn-danger">
                                        <span class="glyphicon glyphicon-trash"></span>
                                    </button>
                                </td>   
                            </tr>
                        
                        <% } %>
                    </tbody>
                </table>
                
               <%   } %>
               
               <a href="form_cadastro_pais.jsp">
                    <button type="button" class="btn btn-primary">
                        <span class="glyphicon glyphicon-plus-sign"></span>
                        Cadastrar País
                    </button>
               </a>
               
            </div>
        </section> 
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
