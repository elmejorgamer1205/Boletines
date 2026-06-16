/**
 * Clase que representa el gremio de los aventureros.
 * Asigna las misiones a los aventureros y se asgura de que cumplan todos los requisitos.
 */

public class Gremio {

    // Array de aventureros que puede almacenar hasta 3 aventureros
    private Aventurero[] aventureros;

    /**
     * Constructor del Gremio.
     */
    public Gremio() {
        this.aventureros = new Aventurero[3];
        for (int i = 0; i < aventureros.length; i++) {
            this.aventureros[i] = new Aventurero();
        }
    }

    /**
     * Metodo para asignar una misión
     * @param indiceAventurero El número identificativo del aventurero
     * @param mision La misión que deberan hacer
     * @throws AventureroException Si el índice no cuadra con ningún aventurero.
     */
    public void asignarMision(int indiceAventurero, Mision mision) throws AventureroException {

        if (indiceAventurero < 0 || indiceAventurero >= aventureros.length) {
            throw new AventureroException("Índice de aventurero no válido: " + indiceAventurero);
        }

        boolean exito = aventureros[indiceAventurero].agregarMision(mision);
        if (!exito) {
            throw new AventureroException("El registro de misiones del aventurero " + indiceAventurero + " está lleno.");
        }
    }

    /**
     * Metodo que inicia el proceso de una expedición global validando la seguridad,
     * la dificultad y los recursos del gremio.
     * @return Un mensaje con el resultado de la validación o confirmación de inicio.
     */
    public String iniciarExpedicionGlobal() {
        if (checkRiesgoCaza()) {
            return "Error crítico: Riesgo de muerte";
        }
        if (calcularDificultadTotal() <= 1000) {
            return "Fallo: Dificultad insuficiente para una expedición global";
        }
        if (!hayUnaCazaPorAventurero() || !tieneOroRescateSuficiente()) {
            return "Fallo: La estrategia del gremio es desequilibrada";
        }
        return "La expedición global se ha iniciado";
    }

    /**
     * Metodo que calcula la sumatoria de la dificultad individual de todos los aventureros actuales.
     * @return La puntuación de dificultad total acumulada.
     */
    private double calcularDificultadTotal() {
        double dificultadTotal = 0;
        for (Aventurero a : aventureros) {
            dificultadTotal += a.calcularDificultadTotal();
        }
        return dificultadTotal;
    }

    /**
     * Verifica si algún aventurero está en riesgo crítico por tener demasiadas misiones de caza.
     * @return true si un aventurero tiene más de una misión de caza activa.
     */
    private boolean checkRiesgoCaza() {
        for (Aventurero a : aventureros) {
            if (a.contarMisionesDeTipo(TipoMision.CAZA) > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este metodo comprueba que la estrategia sea simétrica en el gremio.
     * Cada miembro debe tener asignada exactamente una misión de caza.
     * @return true si todos los aventureros tienen exactamente una misión de caza.
     */
    private boolean hayUnaCazaPorAventurero() {
        for (Aventurero a : aventureros) {
            if (a.contarMisionesDeTipo(TipoMision.CAZA) != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Este metodo evalúa el dinero del gremio para la expedición.
     * El oro destinado a misiones de tipo rescate debe superar el 50% de las recompensas totales.
     * @return True si el gremio cuenta con fondos de rescate suficientes.
     */
    private boolean tieneOroRescateSuficiente() {
        double oroTotalGremio = 0;
        double oroRescateGremio = 0;

        for (Aventurero a : aventureros) {
            oroTotalGremio += a.calcularRecompensaTotal();
            oroRescateGremio += a.calcularRecompensaMisionTipo(TipoMision.RESCATE);
        }
        double mitadOroTotal = oroTotalGremio / 2.0;
        return oroRescateGremio > mitadOroTotal;
    }

}
