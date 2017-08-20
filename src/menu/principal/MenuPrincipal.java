package menu.principal;

import Natacion.Competencia;
import Natacion.Competidor;
import Natacion.interfaz.Piscina;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MenuPrincipal {

    Scanner entrada = new Scanner(System.in);
    private int opcion;
    Competencia competencia = new Competencia();

    public static void main(String[] args) {

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.menuUsuario();
    }

    public void menuUsuario() {
        do {
            System.out.println("******GESTOR DE JUEGOS******");
            System.out.println("1.Competencias de Natación.\n"
                    + "2.Preguntas y Respuestas.\n"
                    + "3.Atrás.");
            System.out.println("Ingrese opción deseada:");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:

                    menuNatacion();
                    break;
                case 2:
                    menuPreguntas();
                default:
                    System.out.println("Error! Digite opción válida!!");
                    menuUsuario();
                    break;
            }
        } while (opcion != 4);
    }

    public void menuNatacion() {
        do {
            System.out.println("1.Ingresar competidor\n2.Eliminar competidor"
                    + "\n3.Iniciar juego\n4.Jugador más ganador"
                    + "\n5.Jugador más perdedor\n6.Estadísticas"
                    + "\n7. Limpiar estadísticas"
                    + "\n8. Empates");
            System.out.println("Ingrese opción deseada:");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Digite nombre del competidor:");
                    entrada.nextLine();
                    String nombre = entrada.nextLine();
                    if (!competencia.agregarCompetidor(new Competidor(nombre))) {
                        System.out.println("No se pueden agregar más competidores");
                    }
                    break;
                case 2:

                    break;
                case 3:
                    competencia.aumentarCantidadJuegos();
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
                    System.out.println("Error! Digite opción válida!!");
                    menuUsuario();
                    break;
            }
        } while (opcion != 8);
    }

    public void menuPreguntas() {

    }
}
