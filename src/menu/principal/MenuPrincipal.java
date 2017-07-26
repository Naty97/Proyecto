package menu.principal;

import java.util.Scanner;

public class MenuPrincipal {

    Scanner entrada = new Scanner(System.in);
    private int opcion;

    public static void main(String[] args) {

    }

    public void menuUsuario() {
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

    }
    public void menuNatacion() {
        
    
    }
    public void menuPreguntas() {
    
    
    }
}
