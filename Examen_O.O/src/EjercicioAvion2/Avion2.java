package EjercicioAvion2;


import EjercicioAvion.Deposito;
import Exceptions.AvionException;

/**
 * Clase que representa un avión, con información sobre su marca, modelo,
 * consumo, depósito de combustible y un conjunto de revisiones.
 */
public class Avion2 {

    /* Marca del avión */
    private String marca;

    /* Modelo del avión */
    private String modelo;

    /* Consumo de combustible por unidad de distancia */
    private int consumo;

    /* Depósito asociado al avión */
    private Deposito deposito;

    /* Array que almacena hasta 5 revisiones del avión */
    private Revision2[] revisiones;

    /**
     * Constructor que inicializa los datos principales del avión
     * y crea el array de revisiones inicial vacío.
     *
     * @param marca marca del avión
     * @param modelo modelo del avión
     * @param consumo consumo por unidad de distancia
     * @param deposito depósito de combustible asociado
     */
    public Avion2(String marca, String modelo, int consumo, Deposito deposito) {
        this.marca = marca;
        this.modelo = modelo;
        this.consumo = consumo;
        this.deposito = deposito;
        this.revisiones = new Revision2[5]; // Capacidad fija de 5 revisiones
    }

    /**
     * Devuelve el índice de la última revisión registrada en el array.
     * Recorre desde el final hacia el inicio.
     *
     * @return índice de la revisión más reciente
     * @throws AvionException si no existe ninguna revisión
     */
    private int indiceUltimaRevision() throws AvionException {
        for (int i = revisiones.length - 1; i >= 0; i--) {
            if (revisiones[i] != null) {
                return i; // Devuelve el índice donde encontró la última revisión
            }
        }
        throw new AvionException("No se encontró ninguna revisión");
    }

    /**
     * Añade una revisión al primer hueco disponible.
     *
     * @param r revisión a añadir
     * @throws AvionException si el array está lleno
     */
    public void añadirRevision(Revision2 r) throws AvionException {
        for (int i = 0; i < revisiones.length; i++) {
            if (revisiones[i] == null) {
                revisiones[i] = r;
                return;
            }
        }
        // Si llega aquí, no había hueco
        throw new AvionException("No se pudo añadir la revisión: no hay espacio disponible");
    }

    /**
     * Determina si el avión puede volar una cierta distancia.
     * Para que pueda volar deben cumplirse:
     *  - el avión está listo (tiene revisión válida)
     *  - el depósito tiene suficiente combustible
     *  - la distancia no es negativa
     *
     * @param distancia distancia a recorrer
     * @return true si puede volar, false si no
     */
    public boolean puedeVolar(double distancia) {
        if (!estaListo() ||
                distancia * consumo > deposito.getCantidadActual() ||
                distancia < 0) {

            return false;
        }
        return true;
    }

    /**
     * Indica si el avión está listo para volar.
     * Depende del estado de la última revisión.
     *
     * @return true si la última revisión está vigente y aprobada
     */
    private boolean estaListo() {
        try {
            return revisiones[indiceUltimaRevision()].isEstado();
        } catch (AvionException e) {
            // Si no hay revisiones, imprime el error y devuelve false
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Representación en texto del avión.
     * Muestra marca, modelo, depósito y si está listo para volar.
     */
    @Override
    public String toString() {
        return "Avion2{" +
                "modelo='" + modelo + '\'' +
                ", deposito=" + deposito +
                ", marca='" + marca + '\'' +
                ", ¿es valido? " + estaListo() +
                '}';
    }
}


