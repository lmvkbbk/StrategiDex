package database;

import java.sql.*;

import static database.conexao.getConexao;

public class criarBd {

    public static void criacaoTabelasBd() throws SQLException {
        try (Connection conexao = getConexao()){
            try(Statement stmt = conexao.createStatement()){
                stmt.execute("""
                        CREATE TABLE IF NOT EXISTS pokemom(
                        if INTEGER PRIMARY KEY AUTOINCREMENT,
                        nome TEXT,
                        tipo1 TEXT,
                        tipo2 TEXT,
                        nivel REAL,
                        hp REAL,
                        atq REAL,
                        def REAL,
                        e_atq REAL,
                        e_def REAL,
                        vel REAL)
                        """);
            } catch (SQLException e){
                System.out.println("ERRO CRIAÇÃO TABELA:"+ e.getMessage());
            }
        }
    }

    public static void preencherTabelas() {
        try(Connection conexao = getConexao()) {
            Statement stmt = conexao.createStatement();
            if (isTableEmpty(stmt)){
                stmt.execute("""
                            INSERT INTO pokemom(nome,tipo1, tipo2, nivel, hp, atq, def, e_atq, e_def, vel) VALUES
                            ('bulbasaur', 'grass', 'poison', 5, 45, 49, 49, 65, 65, 45),
                            ('chamander', 'fire', null, 5, 39, 52, 43, 60, 50, 65),
                            ('squirtle', 'water', null, 5, 44, 48, 65, 50, 64, 43)
                            """);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Banco de dados Base: "+ e.getMessage());
        }
    }

    private static boolean isTableEmpty(Statement stmt){
        try {
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM pokemom");
            rs.next();
            return rs.getInt(1) == 0;
        } catch (SQLException e) {
            System.out.println("Erro na verificação da tabela pokemom, Erro:" + e.getMessage());
            return true;
        }
    }
}
