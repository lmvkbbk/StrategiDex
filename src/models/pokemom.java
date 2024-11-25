package models;

public class pokemom {
    private String nome;
    private String[] tipos;
    private int nivel;
    private int[] stats;
    private int[] ivs;
    private int[] evs;

    public pokemom(String nome, String[] tipos, int nivel, int[] stats, int[] ivs){
        this.nome = nome;
        this.tipos = tipos;
        this.nivel = nivel;
        this.evs = new int[6];
        this.ivs = ivs;
        this.stats = statsFinal(stats);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getTipos() {
        return tipos;
    }

    public void setTipos(String[] tipos) {
        this.tipos = tipos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    public int[] getIvs() {
        return ivs;
    }

    public void setIvs(int[] ivs) {
        this.ivs = ivs;
    }

    public int[] getEvs() {
        return evs;
    }

    public void setEvs(int[] evs) {
        this.evs = evs;
    }

    public int[] statsFinal(int[] stats){
        int [] statsFinal;
        statsFinal = stats;
        int[] ivs = getIvs();
        int[] evs = getEvs();
        statsFinal[0] = (int ) ((((statsFinal[0] * 2 + ivs[0]+(evs[0]/4.0))/100) * getNivel())+ getNivel()+10);
        for (int x = 1; x < 6 ; x++){
            statsFinal[x] = (int) ((((statsFinal[x] * 2 + ivs[x]+(evs[x]/4.0))/100) * getNivel())+5);
        }
        return statsFinal;
    }
}
