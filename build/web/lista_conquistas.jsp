<%--
    Document   : lista_conquistas
    Created on : Sep 29, 2016, 9:29:01 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page import="java.util.Collections"%>
<%@page import="br.estacio.sistemaolimpiada.util.EsporteComMedalhas"%>
<%@page import="br.estacio.sistemaolimpiada.dao.PaisDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/estilos.css">
        <title>Medalhas por esporte</title>
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
                    request.setCharacterEncoding("UTF-8");
                    
                    long codigoPais = Long.parseLong(request.getParameter("codigo"));
                    String nomePais = request.getParameter("nome");
                    
                    PaisDAO paisDAO = new PaisDAO();
                    
                    List<EsporteComMedalhas> medalhasPorEsporte = paisDAO.getTotalMedalhasPorEsporte(codigoPais);
                    
                    Collections.sort(medalhasPorEsporte);
                %>
                
                <div class="page-header">
                    <h1><%= nomePais %></h1>
                </div>
        
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Esporte</th>
                            <th><img src="resources/imagens/medalhas/medalha_ouro.png" title="Ouro" alt="Ouro"/></th>
                            <th><img src="resources/imagens/medalhas/medalha_prata.png" title="Prata" alt="Prata"/></th>
                            <th><img src="resources/imagens/medalhas/medalha_bronze.png" title="Bronze" alt="Bronze"/></th>
                            <th><img src="resources/imagens/medalhas/medalhas.png" title="Total" alt="Total"/></th>
                        </tr>    
                    </thead>
                    <tbody>
                        <% for (EsporteComMedalhas esporteComMedalhas : medalhasPorEsporte) { %>
                            <tr>
                                <td><%= esporteComMedalhas.getNome() %></td>
                                <td><%= "&nbsp&nbsp&nbsp" + esporteComMedalhas.getMedalhasOuro() %></td>
                                <td><%= "&nbsp&nbsp&nbsp" + esporteComMedalhas.getMedalhasPrata() %></td>
                                <td><%= "&nbsp&nbsp&nbsp" + esporteComMedalhas.getMedalhasBronze() %></td>
                                <td><%= "&nbsp&nbsp&nbsp&nbsp&nbsp" + esporteComMedalhas.getTotalMedalhas() %></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
                
            </div>
        </section>
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
