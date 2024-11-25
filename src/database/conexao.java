package database;

import java.sql.*;

public class conexao {
    private static final String URL = "jdbc:sqlite:pokemons.db";

    public static Connection getConexao(){
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL);
        }catch (SQLException e){
            System.out.println("Falha na Conexão de ("+URL+");"+ e.getMessage());
        }
        return conexao;
    }
}
