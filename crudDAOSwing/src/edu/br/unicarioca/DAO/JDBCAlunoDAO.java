package edu.br.unicarioca.DAO;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCAlunoDAO implements AlunoDAO {
 
    private Conexao conexao;
    private Statement stmt;
    
    public JDBCAlunoDAO() throws SQLException, ClassNotFoundException {
        conexao = new Conexao();
        try {
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            throw ex;
        }
    }
 
    @Override
    public int inserir(Aluno aluno) throws SQLException {
        try {
            return stmt.executeUpdate("INSERT INTO aluno (id, nome, cpf) VALUES (" 
                                    + aluno.getId() + ",'" 
                                    + aluno.getNome() + "','" 
                                    + aluno.getCpf() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }
 
    @Override
    public int alterar(Aluno aluno) throws SQLException {
        try {
            return stmt.executeUpdate("UPDATE aluno SET nome = '" 
                                    + aluno.getNome() + "', cpf = '"
                                    + aluno.getCpf() + "' WHERE id = "
                                    + aluno.getId());
        } catch (SQLException e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }
 
    @Override
    public int remover(Aluno aluno) throws SQLException {
        try {
            return stmt.executeUpdate("DELETE FROM Aluno WHERE id = " + aluno.getId());
        } catch (Exception e) {
            throw e;
        } finally {
            conexao.fecharConexao();
        }
    }
 
    @Override
    public List<Aluno> listar() throws SQLException {
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Aluno ORDER BY nome");
            while (rs.next()) {
                Aluno cliente = new Aluno();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                alunos.add(cliente);
            }
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return alunos;
    }

    @Override
    public List<Aluno> listarNome(String nome) throws SQLException {
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Aluno WHERE nome like '%" + nome + "%'");
            while (rs.next()) {
                Aluno cliente = new Aluno();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                alunos.add(cliente);
            }
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return alunos;
    }
}