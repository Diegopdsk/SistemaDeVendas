package DAO;

import Entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDao {

    Connection conect;
    PreparedStatement ps;

    public EstoqueDao() {
    }

    public void salvar(Produto produto) throws Exception {
        try {
            conect = Conexao.getConnection(); // obtem a conexão com o BD
            ps = conect.prepareStatement("INSERT INTO produtos (descricao,valorcusto,valorrevenda,quantidade,unidade,categoria,fabricante) values(?,?,?,?,?,?,?)");

            ps.setString(1, produto.getDescricao());
            ps.setDouble(2, produto.getValorCusto());
            ps.setDouble(3, produto.getValorRevenda());
            ps.setInt(4, produto.getQtd());
            ps.setString(5, produto.getUn());
            ps.setString(6, produto.getCategoria());
            ps.setString(7, produto.getFabricante());

        } catch (SQLException e) {
            throw new Exception("Erro na Sintaxe do SQL", e);
        }

        try {
            ps.execute();
        } catch (SQLException e) {
            throw new Exception("Erro na execução do SQL", e);
        }
    }

    public void atualizar(Produto produto) throws Exception {
        try {
            conect = Conexao.getConnection(); // obtem a conexão com o BD
            ps = conect.prepareStatement("UPDATE produtos SET descricao=? ,valorcusto=?, valorrevenda=?,quantidade=?,unidade=?,categoria=?,fabricante=? WHERE codproduto=?;");

            ps.setString(1, produto.getDescricao());
            ps.setDouble(2, produto.getValorCusto());
            ps.setDouble(3, produto.getValorRevenda());
            ps.setInt(4, produto.getQtd());
            ps.setString(5, produto.getUn());
            ps.setString(6, produto.getCategoria());
            ps.setString(7, produto.getFabricante());

        } catch (SQLException e) {
            throw new Exception("Erro na Sintaxe do SQL", e);
        }

        try {
            ps.execute();
        } catch (SQLException e) {
            throw new Exception("Erro na execução do SQL", e);
        }
    }

    public List buscar(Produto produt) throws Exception {
        try {
            conect = Conexao.getConnection(); // obtem a conexão com o BD
            ps = conect.prepareStatement("SELECT * FROM produtos where descricao=?;");
            ps.setString(1, produt.getDescricao());

            ResultSet resultSet = ps.executeQuery();
            List<Produto> produtos = new ArrayList<>();

            while (resultSet.next()) { // percorre todos os registros da tabela
                Produto produto = new Produto();
                produto.setCodigo(resultSet.getInt("codproduto"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setQtd(resultSet.getInt("quantidade"));
                produto.setUn(resultSet.getString("Unidade"));
                produto.setFabricante(resultSet.getString("fabricante"));
                produto.setValorCusto(resultSet.getDouble("valorcusto"));
                produto.setValorRevenda(resultSet.getDouble("valorrevenda"));
                produtos.add(produto);
            }
            
            Conexao.closeConnection();
            return produtos;
            
        } catch (SQLException e) {
            throw new Exception("Erro na Sintaxe do SQL", e);
        }

    }

}
