<%-- 
    Document   : index
    Created on : Sep 17, 2016, 3:56:55 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="br.estacio.sistemaolimpiada.entity.Pais"%>
<%@page import="br.estacio.sistemaolimpiada.dao.PaisDAO"%>
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
                
                <div class="page-header">
                    <h1>Ranking Geral</h1>
                </div>
                
                <% 
                    PaisDAO paisDAO = new PaisDAO();    
                    List<Pais> paises = paisDAO.selectAllComMedalhas();
                    
                   if (paises == null || paises.isEmpty()) {
                %> 
                
                </br>
                
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-alert"/></span>
                    Nenhum país foi encontrado.
                </div>
                
                <%        
                    } else {
                        
                        Collections.sort(paises);
                        int posicao = 0;
                %>
                
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
                        <% for (Pais pais : paises) { %>
                            
                            <tr>
                                <td><%= ++posicao + "° &nbsp" + pais.getNome() %></td>
                                <td><%= pais.getQtdMedalhasOuro() %></td>
                                <td><%= pais.getQtdMedalhasPrata() %></td>
                                <td><%= pais.getQtdMedalhasBronze() %></td>
                                <td><%= pais.getTotalMedalhas() %></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
                        
                <% } %>    
                
                <a href="form_cadastro_medalhista.jsp">
                    <button type="button" class="btn btn-primary">
                        <span class="glyphicon glyphicon-plus-sign"></span>
                        Cadastrar Medalhista
                    </button>
               </a>
                
            </div>
        </section> 
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
