package DAO;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    Connection conect;
    PreparedStatement ps;

    public UsuarioDao() {

    }

    public void salvar(Usuario usuario) throws Exception {
        try {
            conect = Conexao.getConnection(); // obtem a conexão com o BD
            ps = conect.prepareStatement("INSERT INTO usuario values(?,?,?,?)");
            ps.setString(1, usuario.getMatricula());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getPermissao());

        } catch (SQLException e) {
            throw new Exception("Erro na Sintaxe do SQL", e);
        }

        try {
            ps.execute();
        } catch (SQLException e) {
            throw new Exception("Erro na execução do SQL", e);
        }
    }
    
    public List<Usuario> buscar(Usuario user) throws Exception{
        try {
            conect = Conexao.getConnection(); // obtem a conexão com o BD
            ps = conect.prepareStatement("select * from usuario where nome like ?'%' ");
            ps.setString(1,user.getNome());
            
            ResultSet resultSet = ps.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
    
            while (resultSet.next()) { // percorre todos os registros da tabela
                Usuario usuario = new Usuario();
                usuario.setMatricula(resultSet.getString("matricula"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setPermissao(resultSet.getString("permissao"));
                
                usuarios.add(usuario);
            }
            
            Conexao.closeConnection();
            return usuarios;
            
        } catch (Exception e) {
            throw new Exception("Provavel Erro de sintaxe do SQL", e);
        }
        
    }
    
    public boolean logar(Usuario user) throws Exception{
        try {
            conect = Conexao.getConnection(); // obtem a conexão com o BD
            ps = conect.prepareStatement("select * from usuario where nome=? and senha=? ");
            ps.setString(1,user.getNome());
            ps.setString(1,user.getSenha());
            boolean log;
            ResultSet resultSet = ps.executeQuery();
            log = resultSet.next();
            
            Conexao.closeConnection();
            return log;
            
        } catch (Exception e) {
            throw new Exception("Provavel Erro de sintaxe do SQL", e);
        }
        
    }

}
