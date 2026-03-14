package Boletin6_1.Ejercicio1;

import Boletin6_1.Ejercicio1.exceptions.EquipoException;

import java.util.*;

public class Equipo <T> {

    // --- ATRIBUTOS ---
    // Usamos Set para evitar duplicados en el equipo automáticamente
    private Set<T> alumnos;
    private String nombre;

    // --- CONSTRUCTORES ---
    /**
     * Constructor por defecto para crear un equipo vacío.
     */
    public Equipo(String nombre) {
        // Inicializamos con HashSet, que es rápido y no garantiza orden
        alumnos = new HashSet<>();
        this.nombre = nombre;
    }

    /**
     * Constructor sobrecargado para inicializar un equipo a partir de un Set ya existente.
     * (Muy útil para los métodos de intersección y unión que tienes más abajo).
     */
    public Equipo(Set<T> lista, String nombre) {
        this.alumnos = lista;
        this.nombre = nombre;
    }

    // --- MÉTODOS DE GESTIÓN DEL EQUIPO ---

    /**
     * Añade un nuevo integrante al equipo.
     * @param a El elemento de tipo T a añadir.
     * @throws EquipoException Si el elemento ya existe en el Set.
     */
    public void addAlumno(T a) throws EquipoException{
        // Si add() devuelve false, es porque el Set ya contenía ese elemento.
        // Lanzamos tu excepción personalizada para avisar al programa.
        if (!alumnos.add(a)) {
            throw new EquipoException("Ese alumno ya esta en el equipo");
        }
    }

    /**
     * Elimina un integrante del equipo.
     * @param a El elemento de tipo T a eliminar.
     * @throws EquipoException Si el elemento no se encuentra en el equipo.
     */
    public void removeAlumno(T a) throws EquipoException{
        if (!alumnos.remove(a)){
            throw new EquipoException("Ese alumno no esta en el equipo");
        }
    }

    /**
     * Comprueba si un integrante está en el equipo.
     * Devuelve el objeto si lo encuentra, o null si no.
     */
    public T containsAlumno(T a){
        if (alumnos.contains(a)){
            return a;
        }
        return null;
    }

    /**
     * Convierte el Set (Conjunto) en una List (Lista).
     * Esto es útil si quien llama a este método necesita acceder a los elementos por índice (ej: lista.get(0)).
     */
    public List<T> devolverListaAlumnos(){
        // Pasamos el Set al constructor de ArrayList para hacer la conversión directa
        return new ArrayList<>(alumnos);
    }

    // --- MÉTODOS DE OPERACIONES DE CONJUNTOS ---

    /**
     * Crea un NUEVO equipo con los elementos comunes entre este equipo y otro (INTERSECCIÓN).
     */
    public Equipo<T> interseccionEquipos(String nombreEquipo, Equipo<T> equipo2){
        // 1. Hacemos una copia del Set actual para no modificar el original
        Set<T> nuevaLista = new HashSet<>(alumnos);
        // 2. retainAll() elimina de 'nuevaLista' todo lo que NO esté también en 'equipo2.alumnos'.
        // ¡Es la forma matemáticamente perfecta de hacer una intersección en Java!
        nuevaLista.retainAll(equipo2.alumnos);

        // 3. Devolvemos un nuevo objeto Equipo con el resultado
        return new Equipo<T>(nuevaLista, nombreEquipo);
    }

    /**
     * Crea un NUEVO equipo uniendo todos los elementos de este equipo y otro (UNIÓN).
     */
    public Equipo<T> unifyEquipos(String nombreEquipo, Equipo<T> equipo2){
        // 1. Creamos un Set vacío
        Set<T> nuevoAlumnos = new HashSet<>();
        // 2. Añadimos todos los de este equipo
        nuevoAlumnos.addAll(alumnos);
        // 3. Añadimos todos los del equipo 2 (los repetidos se ignorarán automáticamente gracias al Set)
        nuevoAlumnos.addAll(equipo2.alumnos);

        return new Equipo<T>(nuevoAlumnos, nombreEquipo);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "alumnos=" + alumnos +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    // --- PRUEBAS (MAIN) ---
    public static void main(String[] args) {
        // Alumnos 1 y 2 tienen el mismo nombre pero distinto ADN ("1" y "2").
        Alumno a1 = new Alumno("Jorge","1");
        Alumno a2 = new Alumno("Jorge", "2");
        Alumno a3 = new Alumno("Moi","3"); // "Moi" estará en ambos equipos

        // Creamos equipos especificando que el Genérico <T> será <Alumno>
        Equipo<Alumno> e1 = new Equipo<>("lolo");
        Equipo<Alumno> e2 = new Equipo<>("bla bla bla");

        // Probamos a añadir y capturamos las excepciones si intentamos duplicar
        try { e1.addAlumno(a1); } catch (EquipoException e) { System.out.println(e.getMessage()); }
        try { e1.addAlumno(a3); } catch (EquipoException e) { System.out.println(e.getMessage()); }
        try { e1.addAlumno(a1); } catch (EquipoException e) { System.out.println(e.getMessage()); } // Saltará excepción

        try { e2.addAlumno(a2); } catch (EquipoException e) { System.out.println(e.getMessage()); }
        try { e2.addAlumno(a3); } catch (EquipoException e) { System.out.println(e.getMessage()); }
        try { e2.addAlumno(a2); } catch (EquipoException e) { System.out.println(e.getMessage()); } // Saltará excepción

        // Operaciones de conjuntos
        Equipo<Alumno> nuevo = e1.unifyEquipos("lobla", e2); // Tendrá a1, a2 y a3
        Equipo<Alumno> nuevo2 = e1.interseccionEquipos("blalo", e2); // Solo tendrá a3 (Moi)

        // Impresión de resultados
        System.out.println(e1.devolverListaAlumnos());
        System.out.println(e2.devolverListaAlumnos());
        System.out.println(nuevo.devolverListaAlumnos());
        System.out.println(nuevo2.devolverListaAlumnos());
    }
}