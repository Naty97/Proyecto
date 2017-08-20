package Natacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Competencia {

    List<Competidor> listaCompetidores = new ArrayList<>();
    List<Estadistica> estadisticas = new ArrayList<>();
    private int totalJuegos = 0;
    private int totalEmpates;

    public void agregarCompetidor(Competidor competidor) {
        if (listaCompetidores.size() < 6) {
            estadisticas.add(new Estadistica(competidor.getId()));
            listaCompetidores.add(competidor);

        }
    }

    public List<Estadistica> getEstadisticas() {
        return estadisticas;
    }

    public List<Competidor> getCompetidores() {
        return listaCompetidores;
    }

    public void eliminarCompetidor(int id) {
        for (Competidor item : listaCompetidores) {
            if (item.getId() == id) {
                listaCompetidores.remove(item);
            }
        }
    }

    public Competidor getCompetidor(int indice) {
        return listaCompetidores.get(indice);
    }

    public void iniciarCompetencia() {

    }

    public Competidor obtenerJugadorGanador() {
        int mayor = 0;
        int indice = 0;
        for (Estadistica estadistica : estadisticas) {
            if (estadistica.getVictorias() > mayor) {
                indice = estadisticas.indexOf(estadistica);
                mayor = estadistica.getVictorias();
            }
        }
        return listaCompetidores.get(indice);
    }

    public Competidor obtenerJugadorPerdedor() {
        int mayor = 0;
        int indice = 0;
        for (Estadistica estadistica : estadisticas) {
            if (estadistica.getPerdidas() > mayor) {
                indice = estadisticas.indexOf(estadistica);
                mayor = estadistica.getPerdidas();
            }
        }
        return listaCompetidores.get(indice);
    }

    public void finalizarCompetencia(List<Competidor> ganadores) {
        if (ganadores.size() == 1) {
            Competidor competidor = ganadores.get(0);
            for (Estadistica estadistica : estadisticas) {
                if (competidor.getId() == estadistica.getIdCompetidor()) {
                    estadistica.aumentarRecord();
                }
            }
        } else {
            multiplesGanadores(ganadores);
        }
    }

    public String multiplesGanadores(List<Competidor> ganadores) {
        int[] randoms = new int[ganadores.size()];
        Random randomRifa = new Random();
        int numero;
        for (int i = 0; i < ganadores.size(); i++) {
            numero = randomRifa.nextInt(ganadores.size() * 2) + 1;
            randoms[i] = numero;
        }
        int indice = retornarPosicion(randoms);
        Competidor competidor = ganadores.get(indice);
        for (Competidor item : listaCompetidores) {
            if (competidor.getId() == item.getId()) {
                for (Estadistica estadistica : estadisticas) {
                    if (item.getId() == estadistica.getIdCompetidor()) {
                        estadistica.aumentarRecord();
                        return item.getNombre();
                    } else {
                        estadistica.aumentarPerdidas();
                    }
                }
            }
        }
        return null;
    }

    public int retornarPosicion(int numeros[]) {
        int mayor = 0;
        int posicion = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
                posicion = i;
            }
        }
        return posicion;
    }
    
    public void aumentarCantidadJuegos() {
        totalJuegos++;
    }
    
    public int getCantidadJuegos() {
        return totalJuegos;
    }
    
    public void aumentarCantidadEmpates() {
        totalEmpates++;
    }
    
    public int getCantidadEmpates() {
        return totalEmpates;
    }
}
