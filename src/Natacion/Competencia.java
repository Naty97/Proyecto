
package Natacion;

import java.util.ArrayList;
import java.util.List;


public class Competencia {
      List<Competidor> listaCompetidores = new ArrayList<Competidor>();

    public void agregarCompetidor(Competidor competidor) {
        if(listaCompetidores.size() < 6) {
            listaCompetidores.add(competidor);
        }
    }
    public void eliminarCompetidor(int id) {
        for(Competidor item: listaCompetidores) {
            if(item.getId() == id) {
                listaCompetidores.remove(item);
            } 
        }  
}
    }
