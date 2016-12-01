/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.filter;

import br.estacio.sistemaolimpiada.entity.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */

@WebFilter("/*")
public class ProxyFilter implements Filter {

    private static final Map<String, String> ROTAS_LIVRES = new HashMap<>();
    
    static {
        ROTAS_LIVRES.put("caminhoBase", "/SistemaOlimpiadas/");
        ROTAS_LIVRES.put("index", "/SistemaOlimpiadas/index.jsp");
        ROTAS_LIVRES.put("ranking", "/SistemaOlimpiadas/ranking.jsp");
        ROTAS_LIVRES.put("login", "/SistemaOlimpiadas/login.jsp");
        ROTAS_LIVRES.put("listaConquistas", "/SistemaOlimpiadas/lista_conquistas.jsp");
        ROTAS_LIVRES.put("logout", "/SistemaOlimpiadas/logout.jsp");
        ROTAS_LIVRES.put("frontController", "/SistemaOlimpiadas/sistema");
        ROTAS_LIVRES.put("loginAjax", "/SistemaOlimpiadas/LoginAJAX");
        ROTAS_LIVRES.put("logoutServlet", "/SistemaOlimpiadas/Logout");
        ROTAS_LIVRES.put("resources", "/SistemaOlimpiadas/resources/");
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Usuario usuarioLogado = (Usuario) httpServletRequest.getSession().getAttribute("usuarioLogado");
        String uri = httpServletRequest.getRequestURI();
        
        if (ROTAS_LIVRES.containsValue(uri) || usuarioLogado != null || uri.contains(ROTAS_LIVRES.get("resources"))) {
            chain.doFilter(request, response);
        } else {
            String msgAcessoNegado = "Acesso negado. Favor efetuar o login.";
            httpServletRequest.getSession().setAttribute("msgErro", msgAcessoNegado);
            httpServletRequest.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
    }

    @Override
    public void destroy() {}
    
}
