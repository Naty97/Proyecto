
package Preguntas;

import static Preguntas.Respuesta.id;
import java.util.List;


public class Pregunta {
    static int id=0;
    List <Respuesta>respuestas;
    public Pregunta (List <Respuesta>respuestas){
        id ++;
        this.respuestas= respuestas;
    }
}
