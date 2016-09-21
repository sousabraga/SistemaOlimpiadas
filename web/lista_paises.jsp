<%-- 
    Document   : index
    Created on : Sep 17, 2016, 3:56:55 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page import="br.estacio.sistemaolimpiada.dao.PaisDAO"%>
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
                    PaisDAO paisDAO = new PaisDAO();
                    
                    List<Pais> paises = paisDAO.selectAll();
                    
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
                                    <form action="sistema" id="formExclusao" method="POST">
                                        <input name="regraDeNegocio" type="hidden" value="ExclusaoPais"/>
                                    </form>
                                    
                                    <form action="#" id="formEdicao" method="POST">
                                        <input name="regraDeNegocio" type="hidden" value="EdicaoPais"/>
                                    </form>
                                        
                                    <button name="codigoPais" type="submit" form="formEdicao"
                                            value="<%= String.valueOf(pais.getCodigo()) %>" class="btn btn-warning">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>                                  
                                    
                                    <button name="codigoPais" type="submit" form="formExclusao" 
                                            value="<%= String.valueOf(pais.getCodigo()) %>" class="btn btn-danger">
                                        <span class="glyphicon glyphicon-trash"></span>
                                    </button>                                     
                                </td>
                                
                                <!--
                                <td>
                                    <form action="#" method="POST">
                                        <input name="regraDeNegocio" type="hidden" value="ExclusaoPais"/>
                                        <input name="codigoPais" type="hidden" value="<%= pais.getCodigo() %>"/>
                                        <input type="submit" value="Editar"/>
                                    </form>

                                    <form action="sistema" method="POST">
                                        <input name="regraDeNegocio" type="hidden" value="ExclusaoPais"/>
                                        <input name="codigoPais" type="hidden" value="<%= pais.getCodigo() %>"/>
                                        <input type="submit" value="Excluir"/>
                                    </form>
                                </td> -->
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
