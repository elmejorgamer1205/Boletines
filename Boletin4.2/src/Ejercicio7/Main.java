package Ejercicio7;

import Exceptions.JarraExceptions;
import utils.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {
        Jarra jarraA = null;
        Jarra jarraB = null;
        boolean activo = true;
        System.out.println("Bienvenido al juego de las jarras.\n");
        while (jarraA==null) {
            int capacidadJarraA = MiEntradaSalida.solicitarEntero("Capacidad de la primera jarra: ");
            try {
                jarraA = new Jarra(capacidadJarraA);
            } catch (JarraExceptions e) {
                System.out.println(e.getMessage());
            }
        }while (jarraB==null) {
            int capacidadJarraB = MiEntradaSalida.solicitarEntero("Capacidad de la segunda jarra: ");
            try {
                jarraB = new Jarra(capacidadJarraB);
            } catch (JarraExceptions e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Muy bien. Esto es lo que puedes hacer ahora: \n");
        System.out.println("""
                 * Llenar jarra.\s
                 * Vaciar jarra.\s
                 * Volcar jarra A en B.\s
                 * Volcar jarra B en A.\s
                 * Ver estado de las jarras.\s
                 * salir.\
                """);
        while (activo){
            String accion = MiEntradaSalida.leerLinea("¿Que vas a hacer?\n");
            switch (accion.toLowerCase()){
                case "llenar jarra":
                    String eleccion = elegirJarra();
                    llenarJarra(eleccion,jarraA,jarraB);
                    break;
                case "vaciar jarra":
                    eleccion = elegirJarra();
                    vaciarJarra(eleccion,jarraA,jarraB);
                    break;
                case "volcar jarra a en b":
                    try {
                        jarraA.jarra1EnJarra2(jarraB);
                        System.out.println("Hecho! \n");
                    } catch (JarraExceptions e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "volcar jarra b en a":
                    try {
                        jarraB.jarra1EnJarra2(jarraA);
                        System.out.println("Hecho!\n");
                    } catch (JarraExceptions e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "ver estado de las jarras":
                    System.out.println(jarraA.toString()+"\n");
                    System.out.println(jarraB.toString()+"\n");
                    break;
                case "salir":
                    System.out.println("Los litros totales utilizados son "+Jarra.getContadorDeLitros());
                    activo=false;
                    break;
            }
        }
    }


    public static String elegirJarra(){
        return MiEntradaSalida.leerLinea("¿Que jarra vas a utilizar? (A/B): \n");
    }

    public static void llenarJarra(String eleccion, Jarra jarraA, Jarra jarraB){
        switch (eleccion.toLowerCase()){
            case "a":
                try {
                    jarraA.llenarJarra();
                    System.out.println("Hecho!");
                } catch (JarraExceptions e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "b":
                try {
                    jarraB.llenarJarra();
                    System.out.println("Hecho!");
                } catch (JarraExceptions e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }

    public static void vaciarJarra(String eleccion, Jarra jarraA, Jarra jarraB){
        switch (eleccion.toLowerCase()){
            case "a":
                try {
                    jarraA.vaciarJarra();
                    System.out.println("Hecho!");
                } catch (JarraExceptions e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "b":
                try {
                    jarraB.vaciarJarra();
                    System.out.println("Hecho!");
                } catch (JarraExceptions e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }
}
