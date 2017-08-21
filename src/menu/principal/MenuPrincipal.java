package menu.principal;

import Natacion.Competencia;
import Natacion.Competidor;
import Natacion.interfaz.Piscina;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MenuPrincipal {

    Scanner entrada = new Scanner(System.in);
    private int opcion;
    Competencia competencia = new Competencia();
    private List<Competidor> listaCompetidores = new ArrayList<>();

    public static void main(String[] args) {

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.menuUsuario();
    }

    public void menuUsuario() {
        do {
            JOptionPane.showMessageDialog(null, "******GESTOR DE JUEGOS******");
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1.Competencias de Natación.\n"
                    + "2.Preguntas y Respuestas.\n"
                    + "3.Atrás."));
            switch (opcion) {
                case 1:
                    menuNatacion();
                    break;
                case 2:
                    menuPreguntas();
                default:
                    JOptionPane.showMessageDialog(null, "Error! Digite opción válida!!");
                    menuUsuario();
                    break;
            }
        } while (opcion != 4);
    }

    public void menuNatacion() {
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1.Ingresar competidor\n2.Eliminar competidor"
                    + "\n3.Iniciar juego\n4.Jugador más ganador"
                    + "\n5.Jugador más perdedor\n6.Estadísticas"
                    + "\n7. Limpiar estadísticas"
                    + "\n8. Empates"));
            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Digite nombre del competidor:");
                    if (!competencia.agregarCompetidor(new Competidor(nombre))) {
                        JOptionPane.showInputDialog("No se pueden agregar más competidores");
                    }
                    break;
                case 2:
                    int competidorId = Integer.parseInt(JOptionPane.showInputDialog(this.competencia.mostrarParticipantes()));
                    if (!this.competencia.eliminarCompetidor(competidorId)) {
                        JOptionPane.showMessageDialog(null, "Error! No se ha podido eliminar el competidor");
                    }
                    break;
                case 3:
                    competencia.aumentarCantidadJuegos();
                    String opcion = JOptionPane.showInputDialog("¿Desea escojer los participantes? (Y/N)");
                    if (opcion.equals("Y") || opcion.equals("y")) {
                        int random = (int) Math.floor(Math.random()
                                * listaCompetidores.size() + 2);
                        JOptionPane.showMessageDialog(null,
                                String.format("Podrás escojer %d participantes", random));
                        for (int i = 0; i < random; i++) {
                            boolean valido;
                            do {
                                competidorId = Integer.parseInt(JOptionPane.showInputDialog(
                                        mostrarParticipantes()));
                                valido = competencia.agregarCompetidor(getCompetidor(competidorId));
                                if (!valido) {
                                    JOptionPane.showMessageDialog(null, "El nadador ya está registrado");
                                }
                            } while (!valido);
                        }
                    } else {
                        for (Competidor item : listaCompetidores) {
                            competencia.agregarCompetidor(item);
                        }
                    }
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            Piscina piscina = new Piscina(competencia);
                            piscina.setVisible(true);
                        }
                    });
                    break;

                case 4:
                    System.out.println(competencia.obtenerJugadorGanador().getNombre());
                    break;
                case 5:
                    System.out.println(competencia.obtenerJugadorPerdedor().getNombre());
                    break;
                case 6:
                    int indice = 0;
                    for (Competidor item : competencia.getCompetidores()) {
                        System.out.println(String.format("%s:%s", item.getNombre(),
                                competencia.getEstadisticas().get(indice).getVictorias()));
                        indice++;
                    }
                    break;
                case 7:
                    competencia.limpiarEstadisticas();
                case 8:
                    System.out.println(competencia.getCantidadEmpates());
                default:
                    JOptionPane.showMessageDialog(null, "Error! Digite opción válida!!");
                    break;
            }
        } while (opcion != 8);
    }

    public Competidor getCompetidor(int id) {
        for (Competidor item : listaCompetidores) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private String mostrarParticipantes() {
        StringBuilder nadadores = new StringBuilder();
        for (Competidor item : listaCompetidores) {
            nadadores.append(String.format("%d. %s\n", item.getId(), item.getNombre()));
        }
        return nadadores.toString();
    }

    public void menuPreguntas() {

    }
}
