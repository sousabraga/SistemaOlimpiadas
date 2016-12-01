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
        
        <!-- Bibliotecas CSS -->
        <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
        
        <!-- Bibliotecas JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
        
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
                    String msgErro = (String) request.getSession().getAttribute("msgErro");
                    
                    if (msgSucesso != null) { 
                        request.getSession().removeAttribute("msgSucesso");
                %>    
                        <div class="alert alert-success fade in" role="alert">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <span class="glyphicon glyphicon-ok-sign"></span>
                            <%= msgSucesso %>
                        </div> 
                        
                <%       
                    } else if (msgErro != null) {
                %>
                        <div class="alert alert-danger fade in" role="alert">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <span class="glyphicon glyphicon-alert"></span>
                            <%= msgErro %>
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
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <span class="glyphicon glyphicon-alert"/></span>
                    Nenhum esporte foi encontrado.
                </div>
                
                <%        
                    } else {
                %>
                
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th><h3>Esportes Cadastrados</h3></th>
                            <th><h3>Ações</h3></th>
                        </tr>    
                    </thead>
                    <tbody>
                        <% for (Esporte esporte : esportes) { %>

                            <tr>
                                <td><%= esporte.getNome() %></td>
                                <td>
                                    <button class="btn btn-warning" data-toggle="modal" data-target="#modalEdicao<%= esporte.getCodigo() %>">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button> 
                                    
                                    <button class="btn btn-danger" data-toggle="modal" data-target="#modalExclusao<%= esporte.getCodigo() %>">
                                        <span class="glyphicon glyphicon-trash"></span>
                                    </button> 
                             
                                    <!-- Modal Edição -->
                                    <div class="modal fade" id="modalEdicao<%= esporte.getCodigo() %>" role="dialog">
                                        <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Alteração Esporte</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Realmente deseja alterar o esporte <strong><%= esporte.getNome() %></strong>?</p>
                                                    <form id="formAlteracao<%= esporte.getCodigo() %>" action="sistema" class="list-buttons" method="POST">
                                                        <input type="hidden" name="regraDeNegocio" value="AlteracaoEsporte"/>
                                                        <input type="hidden" name="codigoEsporte" value="<%= esporte.getCodigo() %>"/>
                                                        <div class="form-group">
                                                            <label class="control-label" for="valorInput">Novo nome:</label>
                                                            <input name="nomeEsporte" id="valorInput" type="text" class="form-control" value="<%= esporte.getNome() %>"/> 
                                                        </div>
                                                    </form>  
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" form="formAlteracao<%= esporte.getCodigo() %>" class="btn btn-primary" >Sim</button> 
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>     
                                                                                
                                    <!-- Modal Exclusão -->
                                    <div class="modal fade" id="modalExclusao<%= esporte.getCodigo() %>" role="dialog">
                                        <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Exclusão Esporte</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Realmente deseja excluir o esporte <strong><%= esporte.getNome() %></strong>?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <form action="sistema" class="list-buttons" method="POST">
                                                        <input name="regraDeNegocio" type="hidden" value="ExclusaoEsporte"/>
                                                        <button name="codigoEsporte" type="submit" value="<%= esporte.getCodigo() %>" class="btn btn-primary">Sim</button> 
                                                    </form>   
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div> 
                                                                 
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

