package Natacion;

public class Estadistica {

    private int idCompetidor;
    private int victorias;
    private int perdidas;

    public Estadistica(int idCompetidor) {
        this.idCompetidor = idCompetidor;
        this.victorias = 0;
        this.perdidas = 0;
    }

    public void aumentarRecord() {
        this.victorias++;
    }
    
    public void aumentarPerdidas() {
        this.perdidas++;
    }

    public int getIdCompetidor() {
        return this.idCompetidor;
    }
    
    public int getVictorias() {
        return this.victorias;
    }
    
    public int getPerdidas() {
        return this.perdidas;
    }
}
