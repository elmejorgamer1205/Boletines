/**
 * Esta clase representa las misiones que los aventureros deberan de hacer.
 * Contiene información sobre su id de misión, su tipo de misión, la dificultad de la misión y la recompensa
 * por completar la misión
 */

public class Mision {

    /* Los atributos de la clase encapsulados como privados
    para proteger el acceso a los datos
     */

    private String id;
    private TipoMision tipo;
    private double dificultad;
    private double recompensa;

    /**
     * El constructor para inicializar una nueva misión.
     * @param id El identificador de la misión
     * @param tipo El tipo de la misión
     * @param dificultad La dificultad de la misión
     * @param recompensa La recompensa que reciven por completar la misión
     */


    public Mision(String id, TipoMision tipo, double dificultad, double recompensa) {
        this.id = id;
        this.tipo = tipo;
        this.dificultad = dificultad;
        this.recompensa = recompensa;
    }

    //Los métodos Setter y Getter

    public double getDificultad() {
        return dificultad;
    }

    public void setDificultad(double dificultad) {
        this.dificultad = dificultad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

    public TipoMision getTipo() {
        return tipo;
    }

    public void setTipo(TipoMision tipo) {
        this.tipo = tipo;
    }
}
