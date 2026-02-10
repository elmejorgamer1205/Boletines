package main;
//IMPORTS
//TODO: Incluir los ficheros necesarios si están en otro paquete

import exceptions.DatoInvalidoException;
import models.*;
import utils.UserDataCollector;


public class Principal {

    public static final int MAX_JUGUETES = 10;
    public static Juguete[] juguetes = new Juguete[MAX_JUGUETES];
    public static int numJuguetes = 0;

    public static void main(String[] args) {
        boolean salir = false;

        try {
            FiguraMadera j1 = new FiguraMadera("Cubo", "Cubemax", "España", 2020, "Rojo", 6);
            FiguraMadera j2 = new FiguraMadera("Dodecaedro", "Cubemax", "Camerún", 2022, "Amarillo", 12);
            InstrumentoMusical j3 = new InstrumentoMusical("Xilófono", "Matel", "Brasil", 1999, 10);
            VehiculoPlastico j4 = new VehiculoPlastico("Ferrari F11", "Ferrari", 4);
            VehiculoPlastico j5 = new VehiculoPlastico("Camión Pegaso", "Juguematic", 8);
            PiezaLego j6 = new PiezaLego("Bloque de lego", "Lego", 4, "Azul");
            PiezaLego j7 = new PiezaLego("Bloque de lego", "Lego", 2, "Verde");
            addJuguete(j1);
            addJuguete(j2);
            addJuguete(j3);
            addJuguete(j4);
            addJuguete(j5);
            addJuguete(j6);
            addJuguete(j7);


            do {
                System.out.println(menu());
                int opcion = UserDataCollector.getEnteroMinMax("Selecciona una opción", 1, 7);

                switch (opcion) {
                    case 1:
                        addJuguete(crearFiguraMadera());
                        break;

                    case 2:
                        addJuguete(crearInstrumentoMusical());
                        break;

                    case 3:
                        addJuguete(crearVehiculoPlastico());
                        break;

                    case 4:
                        addJuguete(crearPiezaLego());
                        break;

                    case 5:
                        Juguete j1_c5;
                        do {
                            mostrarJuguetes();
                            int opcion1_c5 = UserDataCollector.getEnteroMinMax("Selecciona un juguete", 1, numJuguetes);
                            j1_c5 = juguetes[opcion1_c5 - 1];
                        }while (!comprobarSiEsApilable(j1_c5));

                        Juguete j2_c5;
                        do {


                            System.out.println("Selecciona ahora el juguete que quieres apilar");
                            mostrarJuguetes();
                            int opcion2_c5 = UserDataCollector.getEnteroMinMax("Selecciona un juguete", 1, numJuguetes);
                            j2_c5 = juguetes[opcion2_c5 - 1];
                        }while (!comprobarSiEsApilable(j2_c5));
                        if (j1_c5 instanceof Apilable apilable){
                            if (apilable.apilar(j2_c5)){
                                System.out.println(j2_c5.getNombre() + " se ha apilado encima de "+ ((Juguete) apilable).getNombre());
                            }
                            else {
                                System.err.println("No se han podido apilar");
                            }
                        }

                        break;

                    case 6:
                        mostrarJuguetes();
                        break;

                    case 7:
                        salir = true;
                }
            } while (!salir);

            System.out.println("Adiós");
        }catch (DatoInvalidoException e){
            System.err.println(e.getMessage());
        }

    }

    private static InstrumentoMusical crearInstrumentoMusical() {

        InstrumentoMusical aux = null;
        boolean creado = false;
        while (!creado) {
            String nombre_c2 = UserDataCollector.getString("Introduce el nombre");
            String marca_c2 = UserDataCollector.getString("Introduce la marca");
            String origen_c2 = UserDataCollector.getString("Introduce el origen de la madera");
            int anoTala_c2 = UserDataCollector.getEntero("Introduce el año de tala de la madera");
            int edadMin_c2 = UserDataCollector.getEntero("Introduce la edad mínima");

            try {
                aux = new InstrumentoMusical(nombre_c2, marca_c2, origen_c2, anoTala_c2, edadMin_c2);
                creado = true;
            } catch (DatoInvalidoException e) {
                System.err.println(e.getMessage());
            }
        }
        return aux;
    }

    private static void mostrarJuguetes() {
        int contador = 1;
        for (int i = 0; i < juguetes.length; i++) {
            if (juguetes[i]!= null){
                System.out.println(contador++ +". "+ juguetes[i].getNombre());
            }
        }
    }

    private static void addJuguete(Juguete juguete) {
        for (int i = 0; i < juguetes.length; i++) {
            if (juguetes[i]== null){
                juguetes[i] = juguete;
                break;
            }
        }
    }

    private static String menu() {
        StringBuilder sb = new StringBuilder("Menú\n");
        sb.append("1. Crear una figura de madera\n");
        sb.append("2. Crear un instrumento musical\n");
        sb.append("3. Crear un vehículo de plástico\n");
        sb.append("4. Crear una pieza de lego\n");
        sb.append("5. Apilar un juguete\n");
        sb.append("6. Mostrar todos los juguetes\n");
        sb.append("7. Salir\n");

        return sb.toString();
    }

    public static FiguraMadera crearFiguraMadera(){

        FiguraMadera aux = null;
        boolean creado = false;

        while (!creado) {

            String nombre = UserDataCollector.getString("Introduce el nombre");
            String marca = UserDataCollector.getString("Introduce la marca");
            String origen = UserDataCollector.getString("Introduce el origen de la madera");
            int anoTala = UserDataCollector.getEntero("Introduce el año de tala de la madera");
            int numLados = UserDataCollector.getEntero("Introduce el número de lados de la figura");
            String color = UserDataCollector.getString("Introduce el color de la figura");

            try {
                aux = new FiguraMadera(nombre, marca, origen, anoTala, color, numLados);
                creado = true;
            } catch (DatoInvalidoException e) {
                System.err.println(e);
            }
        }
        return aux;
    }

    public static VehiculoPlastico crearVehiculoPlastico(){

        VehiculoPlastico aux = null;
        boolean creado = false;

        while (!creado){
            String nombre_c3 = UserDataCollector.getString("Introduce el nombre");
            String marca_c3 = UserDataCollector.getString("Introduce la marca");
            int numRuedas_c3 = UserDataCollector.getEntero("Introduce el número de ruedas");

            try {
                aux = new VehiculoPlastico(nombre_c3,marca_c3,numRuedas_c3);
                creado = true;
            }catch (DatoInvalidoException e){
                System.err.println(e.getMessage());
            }
        }
        return aux;
    }

    public static PiezaLego crearPiezaLego(){

        PiezaLego aux = null;
        boolean creado = false;

        while (!creado){

            String nombre_c4 = UserDataCollector.getString("Introduce el nombre");
            String marca_c4 = UserDataCollector.getString("Introduce la marca");
            String color_c4 = UserDataCollector.getString("Introduce el color");
            int unidades_c4 = UserDataCollector.getEntero("Introduce la medida, en unidades");

            try {
                aux = new PiezaLego(nombre_c4,marca_c4,unidades_c4,color_c4);
                creado = true;
            }catch (DatoInvalidoException e){
                System.err.println(e.getMessage());
            }
        }
        return aux;
    }

    public static boolean comprobarSiEsApilable(Juguete j){
        return j instanceof Apilable;
    }

}
