package br.ufla.dcc.masterchef.dao;

import br.ufla.dcc.masterchef.modelo.Usuario;

/**
 * Interface do Data Access Object (Padrão de Projeto) do Usuário
 * 
 * @author Paulo Jr. e Julio Alves
 */
public interface UsuarioDAO {
    /**
     * Retorna o usuário a partir de seu login
     * 
     * @param login Login do usuário a ser retornado.
     * @return Usuário correspondente ao login passado.
     */
    public Usuario obterUsuarioPeloLogin(String login);
    
    /**
     * Cadastra o usuário passado.
     * 
     * @param usuario Usuário a ser cadastrado.
     */
    public void adicionarUsuario(Usuario usuario);
    
}
