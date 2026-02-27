package Boletin6_1.Ejercicio7;

import exceptions.RecetaException;
import io.MiEntradaSalida;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Recetario {

    private Map<String, Receta> recetas;

    public Recetario() {
        recetas = new HashMap<>();
    }

    public void annadirReceta(Receta nuevaReceta) throws RecetaException {
        if (!recetas.containsKey(nuevaReceta.getNombre())) {
            recetas.put(nuevaReceta.getNombre(), nuevaReceta);
        }
    }

    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
        List<String> nombresDeRecetas = new ArrayList<>(recetas.keySet());
        StringBuilder sb = new StringBuilder();

        nombresDeRecetas.sort(null);

        int contador = 1;

        for (String nombre : nombresDeRecetas) {
            sb.append(contador++).append(". ").append(nombre).append(System.lineSeparator());
        }

        return sb.toString();
    }

    public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {

        StringBuilder sb = new StringBuilder();

        List<Receta> recetasConIngrediente = new ArrayList<>(recetas.values().stream().filter(r1 -> r1.necesitaIngrediente(ingrediente)).toList());
        recetasConIngrediente.sort(Receta::compareTo);

        int contador = 1;

        for (Receta r : recetasConIngrediente) {
            sb.append(contador++).append(". ").append(r.getNombre()).append(" ,tiempo de preparacion: ").append(r.getTiempoDeElaboracion().toHoursPart()).append(" h ").append(r.getTiempoDeElaboracion().toMinutesPart()).append(" m ").append(System.lineSeparator());
        }
        return sb.toString();
    }

    public Receta devolverReceta(String nombreReceta) {
        if (recetas.containsKey(nombreReceta)) {
            return recetas.get(nombreReceta);
        }
        return null;
    }

    public static void main(String[] args) {
        int opcion = 0;

        Recetario miRecetario = new Recetario();
        Ingrediente huevo = new Ingrediente(2, "Huevo");
        Ingrediente mantequilla = new Ingrediente(50, "Mantequilla");
        Ingrediente harina = new Ingrediente(400, "Harina");
        Ingrediente chips = new Ingrediente(150, "Chips de chocolate");
        Ingrediente aceite = new Ingrediente(30, "Aceite");
        Ingrediente azucar = new Ingrediente(100, "Azúcar");
        Ingrediente vainilla = new Ingrediente(20, "Esencia de vainilla");


        Receta tortilla = new Receta("Tortilla", Duration.ofMinutes(20));
        tortilla.annadirIngrediente(huevo);
        tortilla.annadirIngrediente(aceite);
        tortilla.annadirPaso("Batir los huevos en un bol con una pizca de sal.");
        tortilla.annadirPaso("Calentar una sartén con un poco de aceite o mantequilla.");
        tortilla.annadirPaso("Verter los huevos batidos en la sartén caliente.");
        tortilla.annadirPaso("Cuajar el huevo a fuego medio removiendo ligeramente.");
        tortilla.annadirPaso("Doblar la tortilla sobre sí misma con una espátula.");
        tortilla.annadirPaso("Retirar de la sartén y servir en un plato.");

        Receta galletas = new Receta("Galletas", Duration.ofHours(1).plusMinutes(20));
        galletas.annadirIngrediente(harina);
        galletas.annadirIngrediente(huevo);
        galletas.annadirIngrediente(azucar);
        galletas.annadirIngrediente(vainilla);
        galletas.annadirIngrediente(chips);
        galletas.annadirIngrediente(mantequilla);
        galletas.annadirPaso("Precalentar el horno a 180°C.");
        galletas.annadirPaso("Mezclar la mantequilla pomada con el azúcar en un bol.");
        galletas.annadirPaso("Añadir el huevo y la esencia de vainilla y batir bien.");
        galletas.annadirPaso("Tamizar la harina con el bicarbonato y una pizca de sal.");
        galletas.annadirPaso("Incorporar los ingredientes secos a la mezcla húmeda.");
        galletas.annadirPaso("Añadir pepitas de chocolate y mezclar suavemente.");
        galletas.annadirPaso("Formar bolitas con la masa y ponerlas en la bandeja.");
        galletas.annadirPaso("Hornear durante 10-12 minutos hasta que doren.");
        galletas.annadirPaso("Dejar enfriar en una rejilla antes de comer.");

        try {
            miRecetario.annadirReceta(tortilla);
            miRecetario.annadirReceta(galletas);
        } catch (RecetaException e) {
            System.out.println(e.getMessage());
        }


        do {
            System.out.println("\n--- 📖 GESTIÓN DE RECETARIO ---");
            System.out.println("1. Añadir Receta al Recetario");
            System.out.println("2. Listado de Recetas (A-Z)");
            System.out.println("3. Buscar Recetas por Ingrediente (Orden por Tiempo)");
            System.out.println("4. Gestionar una Receta específica (Ingredientes/Pasos)");
            System.out.println("0. Salir");


            try {
                opcion = MiEntradaSalida.leerEnteroRango("Seleccione una opción: ", 0, 4);

                switch (opcion) {
                    case 1:
                        System.out.println("Accediendo a: Añadir Receta...");
                        System.out.println("En proceso....");
                        break;
                    case 2:
                        System.out.println("Generando listado alfabético...");
                        System.out.println(miRecetario.listadoRecetasOrdenadasAlfabeticamente());
                        break;
                    case 3:
                        String ing = MiEntradaSalida.leerLinea("Introduce el nombre del ingrediente: ");
                        System.out.println(miRecetario.listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(ing));
                        break;
                    case 4:
                        String nombreDeLaReceta = MiEntradaSalida.leerLinea("Nombre de la receta que quieras modificar");
                        Receta receta = miRecetario.devolverReceta(nombreDeLaReceta);
                        if (receta != null) {
                            menuEdicionReceta(receta);
                        } else {
                            System.out.println("Esa receta no existe");
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, introduce un número.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);


    }

    /**
     * Submenú para gestionar las acciones internas de una Clase Receta
     */
    private static void menuEdicionReceta(Receta receta) throws RecetaException {
        System.out.println("\n--- 📝 EDICIÓN DE RECETA ---");
        System.out.println("a. Comprobar si necesita ingrediente");
        System.out.println("b. Añadir Ingrediente");
        System.out.println("c. Borrar Ingrediente (y sus pasos)");
        System.out.println("d. Añadir paso detrás de otro");

        String subOpcion = MiEntradaSalida.leerLinea("Seleccione una sub-opción: ").toLowerCase();

        switch (subOpcion) {
            case "a":
                System.out.println("Ejecutando: necesitaIngrediente()...");
                String ing = MiEntradaSalida.leerLinea("¿Que ingrediente quieres comprobar? \n");
                if (receta.necesitaIngrediente(ing)) {
                    System.out.println("Si lo necesita");
                } else {
                    System.out.println("No lo necesita");
                }
                break;
            case "b":
                System.out.println("Ejecutando: annadirIngrediente()...");
                Ingrediente nuevo = crearIngrediente();
                receta.annadirIngrediente(nuevo);
                break;
            case "c":
                System.out.println("Ejecutando: borrarIngrediente()...");
                String ing2 = MiEntradaSalida.leerLinea("¿Que ingrediente quieres borrar? \n");
                Ingrediente borrar = receta.devolverIngrediente(ing2);
                receta.borrarIngrediente(borrar);
                System.out.println("Hecho");
                break;
            case "d":
                System.out.println("Ejecutando: annadirPasoDetrasDe()...");
                String pasoExistente = MiEntradaSalida.leerLinea("Introduce el paso existente: \n");
                String pasoNuevo = MiEntradaSalida.leerLinea("Introduce el paso nuevo: \n");
                receta.annadirPasoDetrasDe(pasoNuevo, pasoExistente);
                break;
            default:
                System.out.println("Regresando al menú principal...");
        }
    }

    public static Ingrediente crearIngrediente() {
        String nombre = MiEntradaSalida.leerLinea("Introduce el nombre del ingrediente: ");
        int cantidad = MiEntradaSalida.leerEnteroPositivo("Introduce la cantidad: \n", false);
        return new Ingrediente(cantidad, nombre);
    }

}



