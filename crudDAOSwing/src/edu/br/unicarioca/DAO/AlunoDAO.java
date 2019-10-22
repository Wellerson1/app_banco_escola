package edu.br.unicarioca.DAO;

import java.sql.SQLException;
import java.util.List;


public interface AlunoDAO {
    public int inserir(Aluno aluno) throws SQLException;
    public int alterar(Aluno aluno) throws SQLException;
    public int remover(Aluno aluno) throws SQLException;
    public List<Aluno> listarNome(String nome) throws SQLException;
    public List<Aluno> listar() throws SQLException;
}