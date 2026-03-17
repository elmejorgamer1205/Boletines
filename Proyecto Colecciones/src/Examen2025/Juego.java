package Examen2025;

import java.util.*;

/**
 * Clase principal que gestiona la lógica del juego, los personajes y los combates.
 */
public class Juego {

    // Se utiliza un Set para almacenar los personajes, lo que garantiza que no haya duplicados.
    private Set<Personaje> personajes;

    /**
     * Constructor del Juego. Inicializa la colección de personajes como un HashSet.
     */
    public Juego() {
        personajes = new HashSet<>();
    }

    public static void main(String[] args) {
        try {
            Juego juego = new Juego();

            // 1. Inicialización de datos
            crearPersonajes(juego);

            // 2. Pruebas de consultas (Queries) utilizando Streams
            System.out.println("Personaje(s) que conocen más ataques:");
            juego.personajeConMasAtaques();

            System.out.println("\nPersonaje(s) con el ataque más poderoso:");
            juego.personajeConAtaqueMasPoderoso();

            System.out.println("\nAtaques ordenados por nombre");
            juego.todosLosAtaquesOrdenadosNombre();

            System.out.println("\nAtaques ordenados por daño de mayor a menor");
            juego.todosLosAtaquesOrdenadosDamage();

            // 3. Pruebas de interacción y combate
            Personaje gohan = juego.buscarPersonaje("gohan", TRaza.SAIYAN);
            Personaje android18 = juego.buscarPersonaje("androide nº18", TRaza.ANDROIDE);

            System.out.println("\nEl mejor ataque disponible de gohan es:");
            Ataque at = juego.ataqueMasDañino(gohan, android18);
            System.out.println(at);

            System.out.println("\nGohan ataca a " + android18.getNombre());
            // Realiza el ataque y actualiza las estadísticas (vida, ki, etc.)
            juego.atacar(gohan, android18, "Special Beam Cannon");

            System.out.println("\nTodos los ataques restantes de todos los jugadores:");
            juego.todosLosAtaquesOrdenadosNombre();

            // 4. Mantenimiento de colecciones
            System.out.println("\nEliminamos los ataques de nivel 1.");
            juego.eliminarAtaquesInferioresANivel(2);

            System.out.println("Todos los ataques restantes de todos los jugadores:");
            juego.todosLosAtaquesOrdenadosNombre();

            // 5. Agrupación de datos
            System.out.println("\nTodos los personajes mostrador por raza:");
            Map<TRaza, List<Personaje>> mapa = juego.devuelveMapaRazas();

            // Itera sobre el mapa generado para imprimir los resultados con un formato limpio
            mapa.entrySet().forEach(e -> {
                System.out.printf("Personajes de la raza %s:\n", e.getKey());
                e.getValue().forEach(p -> System.out.printf("\t%s\n", p.getNombre()));
            });

        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método auxiliar (hardcoded) para instanciar personajes, crearles ataques y añadirlos al juego.
     */
    public static void crearPersonajes(Juego juego) throws DBException {
        // Creación de personajes con sus estadísticas base
        Personaje goku = new Personaje("Goku", TRaza.SAIYAN, 100, 100, 100, 10);
        Personaje vegeta = new Personaje("Vegeta", TRaza.SAIYAN, 90, 20, 90, 25);
        Personaje gohan = new Personaje("Gohan", TRaza.SAIYAN, 80, 15, 80, 70);
        Personaje piccolo = new Personaje("Piccolo", TRaza.NAMEKIANO, 80, 10, 50, 45);
        Personaje android18 = new Personaje("Androide nº18", TRaza.ANDROIDE, 90, 1, 60, 40);

        // ... (El bloque de asignación de ataques se mantiene igual, está muy claro) ...
        Ataque kamehameha1 = new Ataque("Kamehameha", 10, 1, 20);
        Ataque kamehameha2 = new Ataque("Kamehameha", 15, 2, 30);
        Ataque kamehameha3 = new Ataque("Kamehameha", 20, 3, 40);
        goku.addAtaque(kamehameha1);
        goku.addAtaque(kamehameha2);
        goku.addAtaque(kamehameha3);

        // ... (resto de inicializaciones omitidas en el comentario para brevedad, el código original se mantiene)
        Ataque finalFlash1 = new Ataque("Final Flash", 12, 1, 25);
        Ataque galickGun = new Ataque("Galick Gun", 8, 1, 18);
        Ataque bigBangAttack = new Ataque("Big Bang Attack", 15, 2, 35);
        Ataque finalFlash2 = new Ataque("Final Flash", 12, 2, 28);
        vegeta.addAtaque(finalFlash1);
        vegeta.addAtaque(galickGun);
        vegeta.addAtaque(bigBangAttack);
        vegeta.addAtaque(finalFlash2);

        Ataque masenko1 = new Ataque("Masenko", 9, 1, 19);
        Ataque masenko2 = new Ataque("Masenko", 11, 2, 27);
        Ataque specialBeamCannon = new Ataque("Special Beam Cannon", 15, 2, 40);
        Ataque finalAttack = new Ataque("Final Attack", 20, 3, 50);
        gohan.addAtaque(masenko1);
        gohan.addAtaque(masenko2);
        gohan.addAtaque(specialBeamCannon);
        gohan.addAtaque(finalAttack);

        Ataque makankosappo1 = new Ataque("Makankosappo", 10, 1, 22);
        Ataque makankosappo2 = new Ataque("Makankosappo", 15, 2, 30);
        Ataque makankosappo3 = new Ataque("Makankosappo", 20, 3, 38);
        piccolo.addAtaque(makankosappo1);
        piccolo.addAtaque(makankosappo2);
        piccolo.addAtaque(makankosappo3);

        Ataque energyBlast = new Ataque("Energy Blast", 12, 1, 28);
        Ataque powerPunch = new Ataque("Power Punch", 8, 1, 18);
        android18.addAtaque(energyBlast);
        android18.addAtaque(powerPunch);

        // Agregar los personajes al juego
        juego.agregarPersonaje(goku);
        juego.agregarPersonaje(vegeta);
        juego.agregarPersonaje(gohan);
        juego.agregarPersonaje(piccolo);
        juego.agregarPersonaje(android18);
    }

    /**
     * Busca un personaje por su nombre y raza ignorando mayúsculas/minúsculas.
     */
    public Personaje buscarPersonaje(String nombre, TRaza raza) throws DBException {
        return personajes.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre) && p.getRaza().equals(raza))
                .findFirst() // Toma el primer resultado que coincida
                .orElseThrow(() -> new DBException("No se ha encontrado ese personaje"));
    }

    /**
     * Añade un personaje al Set. Al ser un Set, add() devuelve false si ya existe.
     */
    public void agregarPersonaje(Personaje personaje) throws DBException {
        if (!personajes.add(personaje)) {
            throw new DBException("Ese personaje ya esta en el juego");
        }
    }

    /**
     * Busca e imprime el o los personajes que tienen la mayor cantidad de ataques aprendidos.
     */
    public void personajeConMasAtaques() throws DBException {
        if (personajes.isEmpty()) {
            throw new DBException("No hay personajes en el juego");
        }

        // 1. Calculamos cuál es el número máximo de ataques que tiene un personaje actualmente.
        int numeroMaximoDeAtaques = personajes.stream()
                .mapToInt(Personaje::getNumeroAtaques) // Transforma el stream de Personajes a un stream de enteros (cantidad de ataques)
                .max()
                .orElseThrow(() -> new DBException("No se ha podido calcular el máximo de ataques"));

        // 2. Filtramos e imprimimos todos los personajes que coincidan con ese número máximo.
        personajes.stream()
                .filter(p -> p.getNumeroAtaques() == numeroMaximoDeAtaques)
                .forEach(System.out::println);
    }

    /**
     * Imprime todos los ataques únicos del juego, ordenados alfabéticamente.
     */
    public void todosLosAtaquesOrdenadosNombre() {
        personajes.stream()
                .flatMap(p -> p.getAtaques().stream()) // flatMap "aplana" las listas de ataques en un solo flujo (Stream) continuo
                .distinct() // Evita que un mismo ataque salga duplicado si lo tienen varios
                .sorted((a1, a2) -> a1.getNombre().compareToIgnoreCase(a2.getNombre()))
                .forEach(System.out::println);
    }

    /**
     * Imprime todos los ataques del juego, ordenados de mayor a menor daño.
     */
    public void todosLosAtaquesOrdenadosDamage() {
        personajes.stream()
                .flatMap(p -> p.getAtaques().stream())
                // a2 - a1 produce un orden descendente (de mayor daño a menor daño)
                .sorted((a1, a2) -> a2.getDAÑO() - a1.getDAÑO())
                .forEach(System.out::println);
    }

    /**
     * Calcula cuál es el mejor ataque que un personaje (p1) puede realizar teniendo en cuenta su Ki actual.
     * Nota: El parámetro p2 (objetivo) no se está usando en la lógica interna.
     */
    public Ataque ataqueMasDañino(Personaje p1, Personaje p2) throws DBException {
        if (p1.isMuerto() || p1.getKi() < 0) {
            throw new DBException("Este personaje esta muerto o no tiene el ki suficiente para atacar");
        }

        return p1.getAtaques().stream()
                .filter(a -> a.getKI_NECESARIO() <= p1.getKi()) // Solo ataques que puede pagar con su Ki actual
                .max(Ataque::compareTo) // Usa el compareTo que definiste en la clase Ataque (ordena por daño)
                .orElseThrow(() -> new DBException("Moises friki 3"));
    }

    /**
     * Lógica principal de combate. Un personaje ataca a otro.
     */
    public void atacar(Personaje p1, Personaje p2, String ataque) throws DBException {
        if (p1.isMuerto()) {
            throw new DBException("No puedes atacar con este personaje");
        }
        if (p2.isMuerto()) {
            throw new DBException("No puedes atacar a un personaje muerto");
        }

        // Busca el ataque especificado en el repertorio del atacante
        Ataque ataque1 = p1.buscarMejorAtaque(ataque);

        // Actualiza las estadísticas de ambos personajes
        p1.restarKi(ataque1.getKI_NECESARIO());
        p2.recibirDaño(ataque1.getDAÑO());

        // El atacante "olvida" o gasta el ataque tras usarlo
        p1.eliminarAtaque(ataque1);

        // Informa del resultado
        if (p2.isMuerto()) {
            System.out.println(p2.getNombre() + " esta muerto");
        } else {
            System.out.println("A " + p2.getNombre() + " le quedan " + p2.getVida() + " puntos de vida");
        }
    }

    /**
     * Recorre todos los personajes y les borra los ataques cuya perfección sea menor al nivel indicado.
     */
    public void eliminarAtaquesInferioresANivel(int nivel) {
        for (Personaje p : personajes) {
            // removeIf es muy útil y seguro para evitar el error ConcurrentModificationException
            // al eliminar elementos de una colección mientras se itera sobre ella.
            p.getAtaques().removeIf(a -> a.getPERFECCION_DEL_ATAQUE() < nivel);
        }
    }

    /**
     * Agrupa a los personajes según su raza utilizando un Map.
     * Clave (Key): La Raza (TRaza)
     * Valor (Value): Una lista con los personajes que pertenecen a esa raza.
     */
    public Map<TRaza, List<Personaje>> devuelveMapaRazas() {
        Map<TRaza, List<Personaje>> mapaDeRazas = new HashMap<>();

        for (TRaza raza : TRaza.values()) {
            // Filtra los personajes de la iteración actual y los convierte en una Lista
            mapaDeRazas.put(raza, personajes.stream().filter(p -> p.getRaza() == raza).toList());
        }
        return mapaDeRazas;
    }

    /**
     * Busca al personaje que posee el ataque con el atributo de daño más alto de todo el juego.
     */
    private void personajeConAtaqueMasPoderoso() throws DBException {
        // 1. Encuentra el ataque más poderoso entre TODOS los personajes
        Ataque ataqueMasPoderoso = personajes.stream()
                .flatMap(p -> p.getAtaques().stream())
                .max(Ataque::compareTo)
                .orElseThrow(() -> new DBException("Moises friki"));

        // 2. Busca qué personaje tiene ese ataque en concreto e imprime al personaje
        System.out.println(personajes.stream()
                .filter(a -> a.getAtaques().stream().anyMatch(at -> at.equals(ataqueMasPoderoso)))
                .findFirst()
                .orElseThrow(() -> new DBException("Moises friki 2")));
    }
}