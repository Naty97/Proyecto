package menu.principal;

import Natacion.Competencia;
import Natacion.Competidor;
import Natacion.interfaz.Piscina;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    Scanner entrada = new Scanner(System.in);
    private int opcion;
    Competencia competencia = new Competencia();

    public static void main(String[] args) {

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        String nombre1="sara", nombre2="juan", nombre3="maria";
        Competidor nadador1= new Competidor(nombre1); 
        Competidor nadador2= new Competidor(nombre2);
        Competidor nadador3= new Competidor(nombre3);
        List <Competidor> nadador= new  ArrayList <Competidor>();
        nadador.add(nadador1);
        nadador.add(nadador2);
        nadador.add(nadador3);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Piscina piscina = new Piscina(nadador);
                piscina.setVisible(true);
//                 piscina.mover();
            }
        });
       // menuPrincipal.menuUsuario();
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
        }while(opcion != 4);
    }
        
    public void menuNatacion() {
        System.out.println("1.Ingresar competidor\n2.Eliminar competidor\n3.Iniciar juego");
        System.out.println("Ingrese opción deseada:");
        opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Digite nombre del competidor:");
                entrada.nextLine();
                String nombre= entrada.nextLine();
                
                competencia.agregarCompetidor(new Competidor(nombre));
                        
                //menuNatacion();
                  break;
            case 2: 
                
                break;
            case 3:
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Piscina piscina = new Piscina(competencia.getCompetidores());
                piscina.setVisible(true);
//                 piscina.mover();
            }
        });

                break;
            default:
                System.out.println("Error! Digite opción válida!!");
                menuUsuario();
                break;
        }
    
    }
    public void menuPreguntas() {
    
    
    }
}
