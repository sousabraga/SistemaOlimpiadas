<%-- 
    Document   : cadastro_medalhistas
    Created on : Sep 20, 2016, 8:34:02 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page import="br.estacio.sistemaolimpiada.entity.Medalha"%>
<%@page import="br.estacio.sistemaolimpiada.entity.Esporte"%>
<%@page import="java.util.List"%>
<%@page import="br.estacio.sistemaolimpiada.entity.Pais"%>
<%@page import="br.estacio.sistemaolimpiada.dao.EsporteDAO"%>
<%@page import="br.estacio.sistemaolimpiada.dao.PaisDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="resources/estilos.css"/>
        <title>Cadastro de Medalhistas</title>
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
                
                <div class="page-header">
                    <h1>Cadastro de Medalhistas</h1>
                </div>
                
                <%
                    PaisDAO paisDAO = new PaisDAO();
                    List<Pais> paises = paisDAO.selectAll();
                    
                    EsporteDAO esporteDAO = new EsporteDAO();
                    List<Esporte> esportes = esporteDAO.selectAll();      
                %>
                
                <form action="sistema" method="POST">
                    
                    <label for="pais">País:</label>
                    <select name="codigoPais" id="pais">
                        <% for (Pais pais : paises) { %>
                            <option value="<%= pais.getCodigo() %>"><%= pais.getNome() %></option>
                        <% } %>
                    </select>
                    
                    <br/><br/>
                    
                    <label for="esporte">Esporte:</label>
                    <select name="codigoEsporte" id="esporte">
                        <% for (Esporte esporte : esportes) { %>
                            <option value="<%= esporte.getCodigo() %>"><%= esporte.getNome() %></option>
                        <% } %>
                    </select>
                    
                    <br/><br/>
                    
                    <label for="medalha">Medalha:</label>
                    <select name="codigoMedalha" id="medalha">
                        <option value="<%= Medalha.OURO.getCodigo() %>"><%= Medalha.OURO.getDescricao() %></option>
                        <option value="<%= Medalha.PRATA.getCodigo() %>"><%= Medalha.PRATA.getDescricao() %></option>
                        <option value="<%= Medalha.BRONZE.getCodigo() %>"><%= Medalha.BRONZE.getDescricao() %></option>
                    </select>
                    
                    <br/><br/>
                </form>
                    
                <button type="button" class="btn btn-primary">
                    <span class="glyphicon glyphicon-plus-sign"></span>
                    Cadastrar Medalhista
                </button>  
            </div>
        </section>
        
        <jsp:include page="rodape.jsp" flush="true"/>
    </body>
</html>
