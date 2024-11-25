package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static database.conexao.getConexao;

public class gerarpokemon {
    private List<pokemom> pokemons = new ArrayList<>();

    public int[] gerarIvs(){
        Random rd = new Random();
        int[] ivs = new int[6];

        for (int x = 0; x < 6; x++){
            ivs[x] = rd.nextInt(32);
        }
        return ivs;
    }

    public int[] baseStat(int hp,int atq, int def, int eAtq, int eDef,int vel){
        int[] stats = new int[6];
        stats[0] = hp;
        stats[1] = atq;
        stats[2] = def;
        stats[3] = eAtq;
        stats[4] = eDef;
        stats[5] = vel;

        return stats;
    }

    public void Pokemons() {
        try (Connection conexao = getConexao()){
            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT nome,tipo1, tipo2, nivel, hp, atq, def, e_atq, e_def, vel FROM pokemom");
            while(rs.next()) {
                String nome = rs.getString(1);
                String[] tipo = {rs.getString(2), rs.getString(3)};
                int nivel = rs.getInt(4);
                int[] baseStats = {rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)};
                int[] ivs = gerarIvs();

                pokemons.add(new pokemom(nome, tipo, nivel, baseStats, ivs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<pokemom> getPokemons() {
        return pokemons;
    }

}
