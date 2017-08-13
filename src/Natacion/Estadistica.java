
package Natacion;


public class Estadistica {
    private int idCompetidor;
    private int record;
    
    public Estadistica(int idCompetidor){
        this.idCompetidor= idCompetidor;
        this.record= 0;
    }
    public void aumentarRecord (){
        this.record ++;
    }
    public int getIdCompetidor (){
        return this.idCompetidor;
    }
}

