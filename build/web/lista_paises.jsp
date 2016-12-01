<%-- 
    Document   : index
    Created on : Sep 17, 2016, 3:56:55 PM
    Authors    : Matheus Braga, João Lucas e Felipe Bruno
--%>

<%@page import="br.estacio.sistemaolimpiada.dao.PaisDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.estacio.sistemaolimpiada.entity.Pais"%>
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
                <% } %>
                
                <% 
                    PaisDAO paisDAO = new PaisDAO();
                    
                    List<Pais> paises = paisDAO.selectAll();
                    
                    if (paises == null || paises.isEmpty()) {
                %> 
                
                </br>
                
                <div class="alert alert-danger fade in" role="alert">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <span class="glyphicon glyphicon-alert"/></span>
                    Nenhum país foi encontrado.
                </div>
                
                <%        
                    } else {
                %>
                
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th><h3>Países Cadastrados</h3></th>
                            <th><h3>Ações</h3></th>
                        </tr>    
                    </thead>
                    <tbody>
                        <% for (Pais pais : paises) { %>

                            <tr>
                                <td><%= pais.getNome() %></td>
                                
                                <td>                                   
                                    <button class="btn btn-warning" data-toggle="modal" data-target="#modalEdicao<%= pais.getCodigo() %>">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>  
                                                                      
                                    <button class="btn btn-danger" data-toggle="modal" data-target="#modalExclusao<%= pais.getCodigo() %>">
                                        <span class="glyphicon glyphicon-trash"></span>
                                    </button> 
   
                                    <!-- Modal Edição -->
                                    <div class="modal fade" id="modalEdicao<%= pais.getCodigo() %>" role="dialog">
                                        <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Alteração País</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Realmente deseja alterar o país <strong><%= pais.getNome() %></strong>?</p>
                                                    <form id="formAlteracao<%= pais.getCodigo() %>" action="sistema" class="list-buttons" method="POST">
                                                        <input type="hidden" name="regraDeNegocio" value="AlteracaoPais"/>
                                                        <input type="hidden" name="codigoPais" value="<%= pais.getCodigo() %>"/>
                                                        <div class="form-group">
                                                            <label class="control-label" for="valorInput">Novo nome:</label>
                                                            <input name="nomePais" id="valorInput" type="text" class="form-control" value="<%= pais.getNome() %>"/> 
                                                        </div>
                                                    </form>  
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" form="formAlteracao<%= pais.getCodigo() %>" class="btn btn-primary" >Sim</button> 
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>     
                             
                                    <!-- Modal Exclusão -->
                                    <div class="modal fade" id="modalExclusao<%= pais.getCodigo() %>" role="dialog">
                                        <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Exclusão País</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Realmente deseja excluir o país <strong><%= pais.getNome() %></strong>?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <form action="sistema" class="list-buttons" method="POST">
                                                        <input type="hidden" name="regraDeNegocio" value="ExclusaoPais"/>
                                                        <button name="codigoPais" type="submit" value="<%= pais.getCodigo() %>" class="btn btn-primary">Sim</button> 
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
