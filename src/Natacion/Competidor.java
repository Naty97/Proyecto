package Natacion;

public class Competidor {

    static int id = 0;
    private int idCompetidor;
    private String nombre;
    private int movimiento;

    public Competidor(String nombre) {
        this.idCompetidor = id;
        this.nombre = nombre;
        this.movimiento = generarRandom();
        id++;
    }
    
    public void generarMovimiento() {
        this.movimiento = (int) Math.floor(Math.random() * 20 + 1);
    }

    private int generarRandom() {
        return (int) Math.floor(Math.random() * 20 + 1);
    }

    public int getId() {
        return idCompetidor;
    }

    public int getMovimiento() {
        return movimiento;
      
    }
    public String getNombre(){
        return nombre;
    }
}
