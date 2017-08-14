package Natacion;

public class Competidor {

    static int id = 0;
    private String nombre;
    private int movimiento;

    public Competidor(String nombre) {
        id++;
        this.nombre = nombre;
        this.movimiento = generarRandom();
    }

    private int generarRandom() {
        return (int) Math.floor(Math.random() * 10 + 1);
    }

    public int getId() {
        return id;
    }

    public int getMovimiento() {
        return movimiento;
    }
}
