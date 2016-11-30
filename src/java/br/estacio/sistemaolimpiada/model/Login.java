/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.sistemaolimpiada.model;

import br.estacio.sistemaolimpiada.dao.UsuarioDAO;
import br.estacio.sistemaolimpiada.entity.Usuario;
import java.util.Map;

/**
 *
 * @author Matheus Braga
 * @author João Lucas
 * @author Felipe Bruno
 */
public class Login implements RegraDeNegocio {

    public static final String LOGIN_USUARIO_KEY = "login";
    public static final String SENHA_USUARIO_KEY = "senha";
    
    @Override
    public void executarRegraDeNegocio(Map<String, String[]> parametrosRequisicao, Map<String, Object[]> parametrosResposta) {
        String login = parametrosRequisicao.get(LOGIN_USUARIO_KEY)[0];
        String senha = parametrosRequisicao.get(SENHA_USUARIO_KEY)[0];
        
        UsuarioDAO dao = new UsuarioDAO();
        
        Usuario usuario = dao.selectByLoginAndSenha(login, senha);
        
        if (usuario == null) {
            String msgErro[] = new String[1]; 
            msgErro[0] = "Login e/ou senha inválidos. Tente novamente.";
            
            parametrosResposta.put("msgErro", msgErro);
            
        } else {
            Object usuarioEncontrado[] = new Object[1];
            usuarioEncontrado[0] = usuario;
            parametrosResposta.put("usuarioLogado", usuarioEncontrado);
        } 
    }

}
