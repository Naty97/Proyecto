package Natacion;

public class Competidor {
    static int id=0;
    private String nombre;
    
public Competidor( String nombre) {
    id ++;
    this.nombre = nombre;
    
}  
 public int getId() {
        return id;
    }
}
