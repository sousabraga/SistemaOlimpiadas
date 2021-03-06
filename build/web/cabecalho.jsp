<%@page import="br.estacio.sistemaolimpiada.entity.Usuario"%>
<header>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand">Sistema Olimpíadas</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="ranking.jsp">Ranking Geral</a></li>
            </ul>
            
            <% 
                Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado"); 
            
                if (usuarioLogado == null) {
            %>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span>&nbsp Login</a></li>
                        <li><a href="cadastro_usuario.jsp"><span class="glyphicon glyphicon-cloud-upload"></span>&nbsp Cadastre-se</a></li>
                    </ul>
            <% } else { %>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="dashboard.jsp"><span class="glyphicon glyphicon-cog"></span>&nbsp Administrador</a></li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp Logout</a></li>
                    </ul>
            <% } %>
        </div>
    </nav>
</header>
