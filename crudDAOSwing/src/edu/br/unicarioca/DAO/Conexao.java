package edu.br.unicarioca.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;


public class Conexao {
 
    private String driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/escola";
    private String USER = "root";
    private String SENHA = "root";
    private Connection conn;
 
    public Conexao() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }
 
    public Connection getConn() {
        return conn;
    }
 
    public void fecharConexao() throws SQLException {
        try {
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}