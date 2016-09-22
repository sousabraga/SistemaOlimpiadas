<%-- 
    Document   : lista_esportes.jsp
    Created on : Sep 20, 2016, 7:29:53 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page import="br.estacio.sistemaolimpiada.entity.Esporte"%>
<%@page import="br.estacio.sistemaolimpiada.dao.EsporteDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <title>Lista de Esportes</title>
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
                            <span class="glyphicon glyphicon-ok-sign"/></span>
                            <%= msgSucesso %>
                        </div>  
                <%       
                    }
                %>
                
                <% 
                    EsporteDAO esporteDAO = new EsporteDAO();
                    
                    List<Esporte> esportes = esporteDAO.selectAll();
                    
                    if (esportes == null || esportes.isEmpty()) {
                %> 
                
                <div class="alert alert-danger fade in" role="alert">
                    <span class="glyphicon glyphicon-alert"/></span>
                    Nenhum esporte foi encontrado.
                </div>
                
                <%        
                    } else {
                %>
                
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th><h3>Esportes Cadastrados<h3></th>
                            <th><h3>Ações<h3></th>
                        </tr>    
                    </thead>
                    <tbody>
                        <% for (Esporte esporte : esportes) { %>

                            <tr>
                                <td><%= esporte.getNome() %></td>
                                <td>
                                    <form action="#" class="list-buttons" method="POST">
                                        <input name="regraDeNegocio" type="hidden" value="EdicaoEsporte"/>
                                        <button name="codigoEsporte" type="submit" value="<%= esporte.getCodigo() %>" class="btn btn-warning">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button> 
                                    </form>
                                            
                                    <form action="sistema" class="list-buttons" method="POST">
                                        <input name="regraDeNegocio" type="hidden" value="ExclusaoEsporte"/>
                                        <button name="codigoEsporte" type="submit" value="<%= esporte.getCodigo() %>" class="btn btn-danger">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </button>  
                                    </form> 
                                </td>
                            </tr>
                        
                        <% } %>
                    </tbody>
                </table>
                
               <%   } %>
               
               <a href="form_cadastro_esporte.jsp">
                    <button type="button" class="btn btn-primary">
                        <span class="glyphicon glyphicon-plus-sign"></span>
                        Cadastrar Esporte
                    </button>
               </a>
               
            </div>
        </section> 
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>

